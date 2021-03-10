package com.gj.modules.oauth.config;


import com.gj.modules.oauth.AuthExceptionEntryPoint;
import com.gj.modules.oauth.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author ace
 * @create 2018/3/21.
 */
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(new AuthExceptionEntryPoint())
				.accessDeniedHandler(customAccessDeniedHandler);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
    }
}