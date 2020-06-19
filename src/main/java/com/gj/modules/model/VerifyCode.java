package com.gj.modules.model;

import lombok.Data;

/**
 * @author ：gengjian
 * @date ：2020/6/19
 */
@Data
public class VerifyCode {

    private String code;

    private byte[] imgBytes;

    private long expireTime;


}
