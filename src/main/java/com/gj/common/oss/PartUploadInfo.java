package com.gj.common.oss;

import lombok.Data;

@Data
public class PartUploadInfo {
    String uploadId;//上传进程id
    String filename;//文件完整路径
    Integer count;//分片总数
}
