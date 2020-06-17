package com.gj.testpojo;

public enum SequenceLevelEnum {

    SEQUENCE_T1(1,"T1"),
    SEQUENCE_T2(2,"T2"),
    SEQUENCE_T3(3,"T3"),
    SEQUENCE_T4(4,"T4");

    private Integer code;
    private String info;

    SequenceLevelEnum(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
