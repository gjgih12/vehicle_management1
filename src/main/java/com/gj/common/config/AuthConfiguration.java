package com.gj.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.sql.DataSource;

/**
 * @author ：gengjian
 * @date ：2020/7/2
 */
@Configuration
public class AuthConfiguration {

    private static final String[] BY_PASS_URLS = {"/prometheus/**", "/metrics/**", "/openapi/**",
            "/vendor/**", "/styles/**", "/scripts/**", "/views/**", "/img/**", "/i18n/**", "/prefix-path",
            "/health"};

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(AuthenticationManagerBuilder auth,
                                                         DataSource datasource) throws Exception {

        JdbcUserDetailsManager jdbcUserDetailsManager = auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()).dataSource(datasource)
                .usersByUsernameQuery("select Username,Password,Enabled from `Users` where Username = ?")
                .authoritiesByUsernameQuery(
                        "select Username,Authority from `Authorities` where Username = ?")
                .getUserDetailsService();

        jdbcUserDetailsManager.setUserExistsSql("select Username from `Users` where Username = ?");
        jdbcUserDetailsManager
                .setCreateUserSql("insert into `Users` (Username, Password, Enabled) values (?,?,?)");
        jdbcUserDetailsManager
                .setUpdateUserSql("update `Users` set Password = ?, Enabled = ? where id = (select u.id from (select id from `Users` where Username = ?) as u)");
        jdbcUserDetailsManager.setDeleteUserSql("delete from `Users` where id = (select u.id from (select id from `Users` where Username = ?) as u)");
        jdbcUserDetailsManager
                .setCreateAuthoritySql("insert into `Authorities` (Username, Authority) values (?,?)");
        jdbcUserDetailsManager
                .setDeleteUserAuthoritiesSql("delete from `Authorities` where id in (select a.id from (select id from `Authorities` where Username = ?) as a)");
        jdbcUserDetailsManager
                .setChangePasswordSql("update `Users` set Password = ? where id = (select u.id from (select id from `Users` where Username = ?) as u)");

        return jdbcUserDetailsManager;

    }

    @Order(99)
    @Profile("auth")
    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    static class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {

        public static final String USER_ROLE = "user";

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.headers().frameOptions().sameOrigin();
            http.authorizeRequests()
                    .antMatchers(BY_PASS_URLS).permitAll()
                    .antMatchers("/**").hasAnyRole(USER_ROLE);
            http.formLogin().loginPage("/signin").defaultSuccessUrl("/", true).permitAll().failureUrl("/signin?#/error").and()
                    .httpBasic();
            http.logout().logoutUrl("/user/logout").invalidateHttpSession(true).clearAuthentication(true)
                    .logoutSuccessUrl("/signin?#/logout");
            http.exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/signin"));
        }

    }

}
