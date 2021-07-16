package com.gj.modules.oauth.jwt;

import java.util.Date;
import java.util.Map;

/**
 * Created by ace on 2017/9/10.
 */
public interface IJWTInfo {
    /**
     * 获取用户名
     *
     * @return
     */
    String getUniqueName();

    /**
     * 获取用户ID
     *
     * @return
     */
    String getId();

    /**
     * 获取名称
     *
     * @return
     */
    String getName();

    /**
     * 获取过期时间
     *
     * @return
     */
    Date getExpireTime();

    /**
     * 获取其他信息
     */
    Map<String, String> getOtherInfo();

}