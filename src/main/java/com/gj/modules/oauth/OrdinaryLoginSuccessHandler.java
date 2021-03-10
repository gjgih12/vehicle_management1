package com.gj.modules.oauth;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

/**
 *
 * 登录成功，返回token
 * @author: gengjian
 * @create: 2021-01-15 15:43
 **/
@Slf4j
@Component
public class OrdinaryLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Basic ")) {
            throw new UnapprovedClientAuthenticationException("请求头中client信息为空");
        }
        try {
            String[] tokens = extractAndDecodeHeader(header);
            assert tokens.length == 2;
            String clientId = tokens[0];
            String clientSecret = tokens[1];

            JSONObject params = new JSONObject();
            params.put("clientId", clientId);
            params.put("clientSecret", clientSecret);
            params.put("authentication", authentication);

            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
            TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, clientId, clientDetails.getScope(), "mobile");
            OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

            OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
            OAuth2AccessToken oAuth2AccessToken = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
            log.info("获取token 成功：{}", oAuth2AccessToken.getValue());

            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter printWriter = response.getWriter();
            printWriter.append(objectMapper.writeValueAsString(oAuth2AccessToken));
        } catch (IOException e) {
            throw new BadCredentialsException(
                    "Failed to decode basic authentication token");
        }
    }

    /**
     * Decodes the header into a username and password.
     *
     * @throws BadCredentialsException if the Basic header is not present or is not valid
     *                 Base64
     */
    private String[] extractAndDecodeHeader(String header)
            throws IOException {

        byte[] base64Token = header.substring(6).getBytes("UTF-8");
        byte[] decoded;
        try {
            Base64.Decoder baseDecoder = Base64.getDecoder();
            decoded = baseDecoder.decode(base64Token);
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException(
                    "Failed to decode basic authentication token");
        }

        String token = new String(decoded, "UTF-8");

        int delim = token.indexOf(":");

        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        }
        return new String[]{token.substring(0, delim), token.substring(delim + 1)};
    }

    public static void main(String[] args) {
        OrdinaryLoginSuccessHandler ordinaryLoginSuccessHandler = new OrdinaryLoginSuccessHandler();
        try {
            String[] strings = ordinaryLoginSuccessHandler.extractAndDecodeHeader("Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsicmVhZCJdLCJleHBpcmUiOjE2MTE3MzY2NTkwNjMsImV4cCI6MTYxMTc0NzQ1OSwiZGVwYXJ0Ijoicm9vdCIsInVzZXJOYW1lIjoi6LaF57qn566h55CG5ZGYIiwidXNlcklkIjoiMSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiJkNWZjYzg5Yi1hNTE2LTQyZDQtOTRjNi01ZjJlZDg4NDAwOGEiLCJ0ZW5hbnQiOiJhYzg4Y2ViMzg2YWE0MjMxYjA5YmY0NzJjYjkzN2MyNCIsImNsaWVudF9pZCI6InZ1ZSJ9.aIAJptifFzaW8OhTiSMimTLM_9bcYzsaThd8WWbzNz6XjblJHhnf7GjOaJQ1ZFFzOpqphi6Z0RXVJvWYS1iOr66qKdUPCC4cHV9IWUyBGm_DAyNpyj4UiMam86R-qF4mwpI5jgfMzu-uMtrz5jKtrcLcb5lJPr2ecIIkz2e4E3s");
            System.out.println(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
