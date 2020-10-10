package com.gj.common.oss;

import lombok.Data;

@Data
public class PartUploadRes {
    Integer part;
    String eTag;
    Long size;
    Long partCRC;
}
