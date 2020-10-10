package com.gj.common.oss;

import com.gj.common.config.OssConfig;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.io.InputStream;
import java.util.List;

public abstract class OssService {

    protected OssConfig ossConfig;

    protected String getPath(String type, String fileName) {
        String path = type + "/" + DateTime.now().toString("yyyyMMdd") + "/" + fileName;
        if (!StringUtils.isEmpty(ossConfig.getPrefix())) {
            path = ossConfig.getPrefix() + "/" + path;
        }

        return path;
    }

    public abstract String upload(byte[] data, String type, String fileName);

    public abstract String upload(InputStream inputStream, String type, String fileName);

    public abstract PartUploadInfo initPartUpload(String type, String fileName, Integer count);

    public abstract PartUploadRes partUpload(PartUploadInfo partUploadInfo, PartUploadReq partUploadReq);

    public abstract String completePartUpload(PartUploadInfo partUploadInfo, List<PartUploadRes> list);
}
