package com.gj.common.exception;


import com.gj.common.constant.RestCodeConstants;

/**
 * 业务异常基础类
 *
 * @author ace
 * @version 2018/1/13.
 */
public class BusinessException extends BaseException {
    public BusinessException(String message) {
        super(message, RestCodeConstants.EX_BUSINESS_BASE_CODE);
    }

    public BusinessException(String message, int status) {
        super(message, status);
    }
}
