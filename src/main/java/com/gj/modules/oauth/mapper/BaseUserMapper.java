package com.gj.modules.oauth.mapper;

import com.gj.common.vo.security.BaseUserVO;
import org.apache.ibatis.annotations.Param;

public interface BaseUserMapper {
    /**
     * 输入用户名或者手机号查询账户信息
     * @param account   账号
     * @return
     */
    BaseUserVO getBaseUserByUserNameOrMobilePhone(@Param("account") String account);
}
