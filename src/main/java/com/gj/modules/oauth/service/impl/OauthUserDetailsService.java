package com.gj.modules.oauth.service.impl;

import org.springframework.stereotype.Component;

/**
 * @author ：gengjian
 * @date ：Created in 2020/8/31
 */
@Component
public class OauthUserDetailsService /*implements UserDetailsService*/ {

    /*@Autowired
    private BaseUserMapper baseUserMapper;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(StringUtils.isBlank(account)){
//            throw new CustomUsernameNotFoundException("账号输入为空");
        }

        BaseUserVO baseUserVO = baseUserMapper.getBaseUserByUserNameOrMobilePhone(account);

        if(baseUserVO == null){
//            throw new CustomUsernameNotFoundException("账户不存在");
        }
        //Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        //return new OauthUser(baseUserVO.getUserName(),baseUserVO.getPassword(),authorities);

        //authorities 是 roles 集合
        //List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(baseUserVO.getRoles());
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new User(baseUserVO.getUserName(), passwordEncoder.encode(baseUserVO.getPassword()), authorities);
    }*/
}
