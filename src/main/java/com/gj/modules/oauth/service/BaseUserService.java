package com.gj.modules.oauth.service;

import com.gj.common.vo.security.BaseUserVO;
import com.gj.modules.oauth.mapper.BaseUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：gengjian
 * @date ：Created in 2021/1/5
 */
@Service
public class BaseUserService {

    @Autowired
    private BaseUserMapper baseUserMapper;

    public BaseUserVO getBaseUserByUserNameOrMobilePhone(String account){
        return baseUserMapper.getBaseUserByUserNameOrMobilePhone(account);
    }

}
