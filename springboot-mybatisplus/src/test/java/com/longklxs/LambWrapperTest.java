package com.longklxs;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
public class LambWrapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test01(){

        Integer agel = 10;
        Integer ager = 20;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.between(ager!=null && agel != null,User::getAge,agel,ager);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach((user) -> {
            System.out.println(user);
        });
    }
}
