package com.gj.common.exception.auth;


import com.gj.common.constant.RestCodeConstants;
import com.gj.common.exception.BaseException;

/**
 * @author gengjian
 * @date 2020/7/10
 */
public class NonLoginException extends BaseException {
    public NonLoginException(String message) {
        super(message, RestCodeConstants.EX_USER_INVALID_CODE);
    }
}
