package com.gj.common.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.gj.common.config.OssConfig;
import com.gj.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AliyunOssService extends OssService {

    private OSS client;

    public AliyunOssService(OssConfig ossConfig) {
        this.ossConfig = ossConfig;
        this.client = new OSSClientBuilder().build(ossConfig.getEndPoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());
    }

    @Override
    public String upload(byte[] data, String type, String fileName) {
        return upload(new ByteArrayInputStream(data), type, fileName);
    }

    @Override
    public String upload(InputStream inputStream, String type, String fileName) {
        String path = getPath(type, fileName);
        try {
            client.putObject(ossConfig.getBucketName(), path, inputStream);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BusinessException("上传文件失败，请检查配置信息");
        }

        return ossConfig.getDomain() + "/" + path;
    }

    @Override
    public PartUploadInfo initPartUpload(String type, String fileName, Integer count) {
        String path = getPath(type, fileName);
        InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(ossConfig.getBucketName(), path);
        InitiateMultipartUploadResult upresult = client.initiateMultipartUpload(request);
        String uploadId = upresult.getUploadId();
        PartUploadInfo partUploadInfo = new PartUploadInfo();
        partUploadInfo.setFilename(path);
        partUploadInfo.setUploadId(uploadId);
        partUploadInfo.setCount(count);
//        log.info("partUploadInfo:{}", partUploadInfo);

        return partUploadInfo;
    }

    @Override
    public PartUploadRes partUpload(PartUploadInfo partUploadInfo, PartUploadReq partUploadReq) {
        UploadPartRequest uploadPartRequest = new UploadPartRequest();
        uploadPartRequest.setBucketName(ossConfig.getBucketName());
        uploadPartRequest.setKey(partUploadInfo.getFilename());
        uploadPartRequest.setUploadId(partUploadInfo.getUploadId());
        uploadPartRequest.setInputStream(partUploadReq.getInputStream());
        uploadPartRequest.setPartSize(partUploadReq.getSize());
        uploadPartRequest.setPartNumber(partUploadReq.getPart());
        UploadPartResult uploadPartResult = client.uploadPart(uploadPartRequest);
        PartETag partETag = uploadPartResult.getPartETag();

        PartUploadRes partUploadRes = new PartUploadRes();
        partUploadRes.setPart(partETag.getPartNumber());
        partUploadRes.setETag(partETag.getETag());
        partUploadRes.setSize(partETag.getPartSize());
        partUploadRes.setPartCRC(partETag.getPartCRC());
//        log.info("partUploadRes:{}", partUploadRes);

        return partUploadRes;
    }

    @Override
    public String completePartUpload(PartUploadInfo partUploadInfo, List<PartUploadRes> list) {
        if (list == null || list.size() == 0) {
            throw new BusinessException("partRes不能为空");
        }

        List<PartETag> partETags = new ArrayList<>();
        for (PartUploadRes partUploadRes : list) {
            PartETag partETag = new PartETag(partUploadRes.getPart(), partUploadRes.getETag(), partUploadRes.getSize(), partUploadRes.getPartCRC());
            partETags.add(partETag);
        }
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(ossConfig.getBucketName(), partUploadInfo.getFilename(), partUploadInfo.getUploadId(), partETags);
        client.completeMultipartUpload(completeMultipartUploadRequest);

        return ossConfig.getDomain() + "/" + partUploadInfo.getFilename();
    }
}
