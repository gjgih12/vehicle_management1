package com.gj.modules.oauth;

import com.alibaba.fastjson.JSON;
import com.gj.common.msg.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class OrdinaryLoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if (log.isWarnEnabled()) {
            log.warn("errorMsg:{}", e.getMessage(), e);
        }
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter writer = httpServletResponse.getWriter();
        BaseResponse baseResponse = new BaseResponse(HttpStatus.UNAUTHORIZED.value(), "账号或密码错误" );
        writer.write(JSON.toJSONString(baseResponse));
    }
}
