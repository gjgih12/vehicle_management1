package com.gj.modules.oauth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrdinaryLoginFailureHandler /*implements AuthenticationFailureHandler*/ {
    /*@Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if (log.isWarnEnabled()) {
            log.warn("errorMsg:{}", e.getMessage(), e);
        }
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter writer = httpServletResponse.getWriter();
        BaseResponse baseResponse = new BaseResponse(HttpStatus.UNAUTHORIZED.value(), "账号或密码错误" );
        writer.write(JSON.toJSONString(baseResponse));
    }*/
}
