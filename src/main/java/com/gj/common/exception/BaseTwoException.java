/*
 * 项目名称:platform-plus
 * 类名称:BaseTwoException.java
 * 包名称:com.platform.common.exception
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gengjina      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.gj.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 自定义异常
 *
 * @author gengjina
 */
public class BaseTwoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = HttpStatus.INTERNAL_SERVER_ERROR.value();

    public BaseTwoException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseTwoException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BaseTwoException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BaseTwoException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
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
