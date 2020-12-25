package com.gj.utils;

import com.gj.common.constant.CommonConstants;
import com.gj.common.constant.RedisKeyConstants;

import java.util.Date;

/**
 * @author ace
 * @create 2018/3/11.
 */
public class RedisKeyUtil {
    /**
     * @param userId
     * @param expire
     * @return
     */
    public static String buildUserAbleKey(String userId, Date expire) {
        return CommonConstants.REDIS_USER_TOKEN + RedisKeyConstants.USER_ABLE + userId + ":" + expire.getTime();
    }

    /**
     * @param userId
     * @param expire
     * @return
     */
    public static String buildUserDisableKey(String userId, Date expire) {
        return CommonConstants.REDIS_USER_TOKEN + RedisKeyConstants.USER_DISABLE + userId + ":" + expire.getTime();
    }
}
