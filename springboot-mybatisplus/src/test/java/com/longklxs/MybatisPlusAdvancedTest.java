package com.longklxs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.longklxs.domain.User;
import com.longklxs.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MybatisPlusAdvancedTest {

    @Autowired
    UserMapper userMapper;
    @Test
    public void test01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "password", "age");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void test02(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("age");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void test03(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("tel","count(*) as total");
        queryWrapper.groupBy("tel");
        queryWrapper.having("total > 1");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> {
            System.out.println(user);
        });
    }

}
