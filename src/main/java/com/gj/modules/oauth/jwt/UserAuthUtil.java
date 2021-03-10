package com.gj.modules.oauth.jwt;

import com.gj.common.config.KeyConfiguration;
import com.gj.common.config.UserAuthConfig;
import com.gj.common.exception.auth.NonLoginException;
import com.gj.utils.RedisKeyUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by ace on 2017/9/15.
 */
@Configuration
public class UserAuthUtil {

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private JWTHelper jwtHelper;
    @Autowired
    private KeyConfiguration keyConfiguration;

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return getInfoFromToken(token,"");
    }

    public IJWTInfo getInfoFromToken(String token,String url) throws Exception {
        try {
            IJWTInfo infoFromToken = jwtHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
            if (redisTemplate.hasKey(RedisKeyUtil.buildUserDisableKey(infoFromToken.getId(), infoFromToken.getExpireTime()))) {
                throw new NonLoginException("User token is invalid!token:"+token+",url:"+url);
            }
            if (new DateTime(infoFromToken.getExpireTime()).plusMinutes(userAuthConfig.getTokenLimitExpire()).isBeforeNow()) {
                redisTemplate.opsForValue().set(RedisKeyUtil.buildUserDisableKey(infoFromToken.getId(), infoFromToken.getExpireTime()), "1");
                redisTemplate.delete(RedisKeyUtil.buildUserAbleKey(infoFromToken.getId(), infoFromToken.getExpireTime()));
                throw new NonLoginException("User token expired!token:"+token+",url:"+url);
            }
            return infoFromToken;
        } catch (ExpiredJwtException ex) {
            throw new NonLoginException("User token expired!token:"+token+",url:"+url);
        } catch (SignatureException ex) {
            throw new NonLoginException("User token signature error!token:"+token+",url:"+url);
        } catch (IllegalArgumentException ex) {
            throw new NonLoginException("User token is null or empty!token:"+token+",url:"+url);
        }
    }
}
