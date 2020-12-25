package com.gj.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author ：gengjian
 * @date ：Created in 2020/12/25
 */
@Component
public class CallAboutTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest(){

        redisTemplate.opsForValue().set("GENG","123456");

    }

}
