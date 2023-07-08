package com.longklxs;

import com.longklxs.domain.User;
import com.longklxs.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;
    @Test
    public void findTest(){
        List<User> users = userMapper.selectList(null);
        users.forEach((u) ->{
            System.out.println(u);
        });
    }

}
