package com.longklxs;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testForZSet(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
//        zSetOperations.add("sellOrder","book",10);
//        zSetOperations.add("sellOrder","phone",15);
//        zSetOperations.add("sellOrder","computer",20);
        Long size = zSetOperations.size("sellOrder");
        System.out.println(size);
        Set sellOrder = zSetOperations.range("sellOrder",0,2);
        for(Object o : sellOrder){
            System.out.println(o);
        }
        System.out.println("----------------------");
        Set reverseOrder = zSetOperations.reverseRange("sellOrder", 0, 2);
        for(Object o : reverseOrder){
            System.out.println(o);
        }

        Long remove = zSetOperations.remove("sellOrder", "computer");
        System.out.println(remove);
    }


    @Test
    public void testForSet(){
        SetOperations setOperations = redisTemplate.opsForSet();
//        setOperations.add("address","北京","天津","石家庄","廊坊","保定");
        Long size = setOperations.size("address");
        System.out.println(size);
        System.out.println("-------------------------");
        Set address = setOperations.members("address");
        for (Object o : address){
            System.out.println(o);
        }
//        Long remove = setOperations.remove("address","天津");
//        System.out.println(remove);
    }


    @Test
    public void testForList(){
        ListOperations listOperations = redisTemplate.opsForList();
//        listOperations.leftPush("studentNames","张三");
//        listOperations.leftPushAll("studentNames","老王","test","qf2303");
        Long size = listOperations.size("studentNames");
        System.out.println(size);
        System.out.println("-------------------");
        List names = listOperations.range("studentNames", 0, 3);
        System.out.println(names);

        List names1 = listOperations.range("studentNames", 0, -1);
        System.out.println(names1);
        Object studentNames = listOperations.rightPop("studentNames");
        System.out.println(studentNames);
    }

    @Test
    public void testForHash(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("student","name","张三");
        Map<String, Object> map = new HashMap<>();
        map.put("age",20);
        map.put("gender","男");
        map.put("address","北京");
        hashOperations.putAll("student",map);
        Object address = hashOperations.get("student", "address");
        System.out.println(address);

        Set keys = hashOperations.keys("student");
        for(Object key : keys){
            System.out.println(key);
        }
        System.out.println("---------------------------");
        List values = hashOperations.values("student");
        values.forEach(v -> {
            System.out.println(v);
        });
    }


    @Test
    public void testForString(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("ValueOperations","SpringDataRedisForString");
        Object value = valueOperations.get("ValueOperations");
        System.out.println(value);
        valueOperations.set("code","123456",5, TimeUnit.MINUTES);

        valueOperations.setIfAbsent("ValueOperations","111");
        Object valueOperations1 = valueOperations.get("ValueOperations");
        System.out.println(valueOperations1);

    }

    @Test
    public void testRedisTemplate(){
        System.out.println(redisTemplate);
        redisTemplate.opsForValue().set("username","测试存入");
        Object username = redisTemplate.opsForValue().get("username");
        System.out.println(username);

    }

}
