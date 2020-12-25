package com.gj.handler;

import com.gj.common.constant.RestCodeConstants;
import com.gj.common.exception.BaseException;
import com.gj.common.exception.BusinessException;
import com.gj.common.exception.auth.ClientTokenException;
import com.gj.common.exception.auth.NonLoginException;
import com.gj.common.exception.auth.UserInvalidException;
import com.gj.common.msg.BaseResponse;
import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常拦截处理器
 *
 * @author ace
 * @version 2017/9/8
 */
@ControllerAdvice("com.gj")
@ResponseBody
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        logger.error(ex.getMessage(), ex);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(HttpServletResponse response, Exception ex) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

    @ExceptionHandler(ClientTokenException.class)
    public BaseResponse clientTokenExceptionHandler(HttpServletResponse response, ClientTokenException ex) {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(NonLoginException.class)
    public BaseResponse userTokenExceptionHandler(HttpServletResponse response, NonLoginException ex) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(UserInvalidException.class)
    public BaseResponse userInvalidExceptionHandler(HttpServletResponse response, UserInvalidException ex) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(HttpServletResponse response, BusinessException ex) {
        logger.info(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public BaseResponse systemExceptionHandler(HttpServletResponse response, BusinessException ex) {
        logger.info(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    public BaseResponse illegalStateExceptionHandler(HttpServletResponse response, IllegalStateException ex) {
        logger.info(ex.getMessage(), ex);
        return new BaseResponse(RestCodeConstants.EX_BUSINESS_BASE_CODE, ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public BaseResponse illegalArgumentException(HttpServletResponse response, IllegalArgumentException ex) {
        logger.info(ex.getMessage(), ex);
        return new BaseResponse(RestCodeConstants.EX_BUSINESS_BASE_CODE, ex.getMessage());
    }
}
