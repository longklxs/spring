package com.longklxs;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void test01(){
        redisTemplate.opsForValue().set("kk","vv");
        Object kk = redisTemplate.opsForValue().get("kk");
        System.out.println(kk);
    }
}
