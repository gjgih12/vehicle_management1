package com.gj.modules.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.gj.common.exception.BusinessException;
import com.gj.common.msg.ObjectRestResponse;
import com.gj.common.oss.*;
import com.gj.common.uid.UidGenerator;
import com.gj.utils.Utils;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/oss")
@Slf4j
public class OssController {

    @Autowired
    OssFactory ossFactory;
    @Autowired
    UidGenerator uidGenerator;

    @GetMapping("/aa")
    public Object aa(){
        ObjectRestResponse<Object> res = new ObjectRestResponse<>();
        res.setData("111");
        return res;
    }


    @GetMapping("/upload")
    public Object upload (
//        HttpServletRequest request,
        @RequestParam("file") MultipartFile file,
        @RequestParam(value = "type", required = false) String type
    ) throws Exception {
        if (file.isEmpty()) {
            throw new BusinessException("上传文件不能为空");
        }
        /*boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            throw new BusinessException("上传文件不能为空");
        }*/
        if (StringUtils.isEmpty(type)) {
            type = "temp";
        }

        String originalFileName = file.getOriginalFilename();
        //String fileNameMd5 = Utils.md5(originalFileName + uidGenerator.getUid());
        String fileNameMd5 = Utils.md5(originalFileName + System.currentTimeMillis());
        String fileName = fileNameMd5;
        int dotIndex = originalFileName.lastIndexOf(".");
        String fileType = "";
        if (dotIndex > -1) {
            fileType = originalFileName.substring(dotIndex+1);
        }
        if (!StringUtils.isEmpty(fileType)) {
            fileName += "." + fileType;
        }

        String url = ossFactory.build().upload(file.getBytes(), type, fileName);
        ObjectRestResponse<Object> res = new ObjectRestResponse<>();

        res.setData(url);

        return res;
    }

    @PostMapping("/prePartUpload")
//    @CrossOrigin(origins = "*")
    public Object partUpload (
            @RequestParam("filename") String filename,
            @RequestParam("count") Integer count,
            @RequestParam(value = "type", required = false) String type
    ) {
        if (StringUtils.isEmpty(filename)) {
            throw new BusinessException("filename不能为空");
        }
        if (StringUtils.isEmpty(type)) {
            type = "temp";
        }

        String fileNameMd5 = Utils.md5(filename + uidGenerator.getUid());
        int dotIndex = filename.lastIndexOf(".");
        String fileType = "";
        if (dotIndex > -1) {
            fileType = filename.substring(dotIndex+1);
        }
        if (!StringUtils.isEmpty(fileType)) {
            fileNameMd5 += "." + fileType;
        }

        OssService ossService = ossFactory.build();
        PartUploadInfo partUploadInfo = ossService.initPartUpload(type, fileNameMd5, count);
        //redisHelper.setPartUploadInfo(partUploadInfo.getUploadId(), partUploadInfo);

        //return JsonResponse.success(partUploadInfo.getUploadId());
        return null;
    }

    @PostMapping("/partUpload")
//    @CrossOrigin(origins = "*")
    public Object partUpload (
            HttpServletRequest request,
            @RequestParam("uploadId") String uploadId,
            @RequestParam("part") Integer part,
            @RequestParam("file") MultipartFile file
    ) throws Exception {
        if (StringUtils.isEmpty(uploadId)) {
            throw new BusinessException("uploadId不能为空");
        }
        if (part == null || part.intValue() <= 0) {
            throw new BusinessException("part分片号不合法");
        }
        if (file == null) {
            throw new BusinessException("上传文件不能为空");
        }
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            throw new BusinessException("上传文件不能为空");
        }

//        PartUploadInfo partUploadInfo = redisHelper.getPartUploadInfo(uploadId);
//        if (partUploadInfo == null) {
//            throw new ParamsException("uploadId不存在");
//        }

        try {
            OssService ossService = ossFactory.build();
            PartUploadReq partUploadReq = new PartUploadReq();
            //partUploadReq.setUploadId(partUploadInfo.getUploadId());
            partUploadReq.setInputStream(file.getInputStream());
            partUploadReq.setPart(part);
            partUploadReq.setSize(file.getSize());
            //PartUploadRes partUploadRes = ossService.partUpload(partUploadInfo, partUploadReq);
            //redisHelper.pushPartUploadRes(uploadId, partUploadRes);
            //Long size = redisHelper.sizePartUploadRes(uploadId);

            JSONObject jsonObject = new JSONObject();
//            if (partUploadInfo.getCount().intValue() == size.longValue()) {
//                String url = ossService.completePartUpload(partUploadInfo, redisHelper.getAllPartUploadRes(uploadId));
//                jsonObject.put("status", "OK");
//                jsonObject.put("url", url);
//                return JsonResponse.success(jsonObject);
//            } else {
//                jsonObject.put("status", "uploading");
//                return JsonResponse.success(jsonObject);
//            }
        } catch (Exception e) {
            log.error("上传失败", e);
            //return JsonResponse.error(JsonResponse.ERR_CODE_BUSINESS_ERR, "上传失败");
            return null;
        }
        return null;
    }
}
