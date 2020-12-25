package com.gj.common.exception.auth;


import com.gj.common.constant.RestCodeConstants;
import com.gj.common.exception.BaseException;

/**
 * @author gengjian
 * @dat
 */
public class ClientTokenException extends BaseException {
    public ClientTokenException(String message) {
        super(message, RestCodeConstants.EX_CLIENT_INVALID_CODE);
    }
}
