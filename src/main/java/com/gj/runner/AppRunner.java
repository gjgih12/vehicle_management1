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

    @Override
    public void run(String... args) throws Exception {
        boolean flag = false;
        if (redisTemplate.hasKey(RedisKeyConstants.REDIS_USER_PRI_KEY) && redisTemplate.hasKey(RedisKeyConstants.REDIS_USER_PUB_KEY)) {
            try {
                keyConfiguration.setUserPriKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(RedisKeyConstants.REDIS_USER_PRI_KEY).toString()));
                keyConfiguration.setUserPubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(RedisKeyConstants.REDIS_USER_PUB_KEY).toString()));
                flag = true;
            } catch (Exception e) {
                log.error("初始化用户公钥/密钥异常...", e);
            }
        }
        if (!flag) {
            Map<String, byte[]> keyMap = rsaKeyHelper.generateKey(keyConfiguration.getUserSecret());
            keyConfiguration.setUserPriKey(keyMap.get("pri"));
            keyConfiguration.setUserPubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(RedisKeyConstants.REDIS_USER_PRI_KEY, rsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(RedisKeyConstants.REDIS_USER_PUB_KEY, rsaKeyHelper.toHexString(keyMap.get("pub")));
        }
        log.info("完成用户公钥/密钥的初始化...");
    }
}
