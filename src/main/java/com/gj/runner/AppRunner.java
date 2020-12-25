package com.gj.runner;

import com.gj.common.config.KeyConfiguration;
import com.gj.common.constant.RedisKeyConstants;
import com.gj.utils.RsaKeyHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

/**
 * @author ：gengjian
 * @date ：Created in 2020/12/23
 */
@Configuration
@Slf4j
public class AppRunner implements CommandLineRunner {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private KeyConfiguration keyConfiguration;

    @Autowired
    private RsaKeyHelper rsaKeyHelper;

//    @Autowired
//    private GatewayRouteBiz gatewayRouteBiz;

    @Override
    public void run(String... args) throws Exception {
        boolean flag = false;
        if (redisTemplate.hasKey(RedisKeyConstants.REDIS_USER_PRI_KEY) && redisTemplate.hasKey(RedisKeyConstants.REDIS_USER_PUB_KEY)) {
            try {
                keyConfiguration.setUserPriKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(RedisKeyConstants.REDIS_USER_PRI_KEY).toString()));
                keyConfiguration.setUserPubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(RedisKeyConstants.REDIS_USER_PUB_KEY).toString()));
            } catch (Exception e) {
                log.error("初始化用户公钥/密钥异常...", e);
                flag = true;
            }
        }
        if (flag) {
            Map<String, byte[]> keyMap = rsaKeyHelper.generateKey(keyConfiguration.getUserSecret());
            keyConfiguration.setUserPriKey(keyMap.get("pri"));
            keyConfiguration.setUserPubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(RedisKeyConstants.REDIS_USER_PRI_KEY, rsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(RedisKeyConstants.REDIS_USER_PUB_KEY, rsaKeyHelper.toHexString(keyMap.get("pub")));
        }
        log.info("完成用户公钥/密钥的初始化...");
        /*flag = false;
        if (redisTemplate.hasKey(RedisKeyConstants.REDIS_SERVICE_PRI_KEY) && redisTemplate.hasKey(RedisKeyConstants.REDIS_SERVICE_PUB_KEY)) {
            try {
                keyConfiguration.setServicePriKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(RedisKeyConstants.REDIS_SERVICE_PRI_KEY).toString()));
                keyConfiguration.setServicePubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(RedisKeyConstants.REDIS_SERVICE_PUB_KEY).toString()));
            } catch (Exception e) {
                log.error("初始化服务公钥/密钥异常...", e);
                flag = true;
            }
        } else {
            flag = true;
        }
        if (flag) {
            Map<String, byte[]> keyMap = rsaKeyHelper.generateKey(keyConfiguration.getServiceSecret());
            keyConfiguration.setServicePriKey(keyMap.get("pri"));
            keyConfiguration.setServicePubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(RedisKeyConstants.REDIS_SERVICE_PRI_KEY, rsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(RedisKeyConstants.REDIS_SERVICE_PUB_KEY, rsaKeyHelper.toHexString(keyMap.get("pub")));
        }
        log.info("完成服务公钥/密钥的初始化...");*/
        /*List<GatewayRoute> gatewayRoutes = gatewayRouteBiz.selectListAll();
        redisTemplate.opsForValue().set(RedisKeyConstants.ZUUL_ROUTE_KEY, JSON.toJSONString(gatewayRoutes));
        log.info("完成网关路由的更新...");*/
    }
}
