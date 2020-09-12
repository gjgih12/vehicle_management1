package com.gj.modules.oauth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * 登录发生异常时指定自定义异常
 */
@Component("customWebResponseExceptionTranslator")
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
	@Override
	public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {

		//OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
		String msg = "Bad credentials".equals(e.getMessage()) ? "账号或密码错误" : e.getMessage();
		return ResponseEntity
				.status(400)
				.body(new CustomOauthException(msg));
	}
}