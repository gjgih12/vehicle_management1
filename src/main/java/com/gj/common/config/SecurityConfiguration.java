package com.gj.common.config;

import com.gj.modules.oauth.service.impl.OauthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ：gengjian
 * @date ：2020/7/3
 * Description: Security 配置类
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] BY_PASS_URLS = {"/","/index","/login","/toLogin","/error",
            "/code/image","/index/**","/js/**","/minio/**","/funTest/**","/oss/**","/car/nakedCar/**"};

    @Autowired
    private OauthUserDetailsService oauthUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 在内存中创建一个名为 "user" 的用户，密码为 "pwd"，拥有 "USER" 权限，密码使用BCryptPasswordEncoder加密
         */
        /*auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user").password(new BCryptPasswordEncoder().encode("pwd")).roles("USER");*/
        /**
         * 在内存中创建一个名为 "admin" 的用户，密码为 "pwd"，拥有 "USER" 和"ADMIN"权限
         */
        /*auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("pwd")).roles("USER","ADMIN");*/

        auth.userDetailsService(oauthUserDetailsService).passwordEncoder(passwordEncoder());

    }

    /**
     * 匹配 "/","/index" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 匹配 "/admin" 及其以下所有路径，都需要 "ADMIN" 权限
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(BY_PASS_URLS).permitAll()//这些路径都是放开的
                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
                //.antMatchers("/user/**").hasRole("USER")
                //.antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/toLogin")
                .loginProcessingUrl("/login")    //自定义登录表单请求路径
                .defaultSuccessUrl("/backHome")  //登录成功默认跳转页路径
                .and()
                .csrf().disable()   //关闭 CSRF 保护(不然不验证token的话post请求403)
                .logout().logoutUrl("/logout").logoutSuccessUrl("/toLogin");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
