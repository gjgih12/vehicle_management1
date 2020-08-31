package com.gj.modules.oauth.service.impl;

import com.gj.common.vo.security.BaseUserVO;
import com.gj.modules.oauth.bean.OauthUser;
import com.gj.modules.oauth.mapper.BaseUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：gengjian
 * @date ：Created in 2020/8/31
 */
@Component
public class OauthUserDetailsService implements UserDetailsService {

    @Autowired
    private BaseUserMapper baseUserMapper;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

        if(StringUtils.isBlank(account)){
            throw new UsernameNotFoundException("账号输入为空");
        }

        BaseUserVO baseUserVO = baseUserMapper.getBaseUserByUserNameOrMobilePhone(account);

        if(baseUserVO == null){
            throw new UsernameNotFoundException("账户不存在");
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        return new OauthUser(baseUserVO.getUserName(),baseUserVO.getPassword(),authorities);
    }
}
