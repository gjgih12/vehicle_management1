package com.gj.modules.oauth.provider;

import org.springframework.stereotype.Component;

/**
 * @author: gengjian
 * @create: 2021-01-05
 **/
@Component
public class OrdinaryLoginAuthenticationProvider /*extends AbstractUserDetailsAuthenticationProvider*/ {

   /* @Autowired
    private OauthUserDetailsService userDetailsService;

    *//**
     * 添加自定义身份认证检查
     *
     * @param userDetails  用户信息
     * @param authentication 用户名密码令牌
     * @throws AuthenticationException 异常
     *//*
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        //校验密码
        if(ObjectUtils.isEmpty(authentication.getCredentials())){
            throw new BadCredentialsException("用户名或密码错误");
        }
        String presentedPassword = authentication.getCredentials().toString();
        if (!presentedPassword.equals( userDetails.getPassword())) {
            throw new BadCredentialsException("用户名或密码错误");
        }
    }


    @Override
    protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return userDetailsService.loadUserByUsername(userName);
    }
*/
}
