package com.gj.common.exception;

import org.springframework.http.HttpStatus;

import javax.naming.AuthenticationException;

/**
 * @author ：gengjian
 * @date ：2020/7/3
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = HttpStatus.INTERNAL_SERVER_ERROR.value();



    /**
     * 构造函数
     * @param msg
     */
    public ValidateCodeException(String msg) {
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
