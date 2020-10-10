package com.gj.common.oss;

import lombok.Data;

import java.io.InputStream;

@Data
public class PartUploadReq {
    String uploadId;//上传进程id
    Integer part;//分片号
    Long size;//分片大小，最小为100KB
    InputStream inputStream;//分片文件流
}
