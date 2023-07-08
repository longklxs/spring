package com.longklxs;

import com.longklxs.domain.User;
import com.longklxs.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CRUDTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectTest(){
        User user = userMapper.selectById(7);
        System.out.println(user);
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setTel("11111111");
        user.setPassword("123");
        user.setIsDelete(1);
        userMapper.insert(user);
    }

    @Test
    public void updateTest(){
        User user = userMapper.selectById(1668811294356025345L);
        user.setName("呵呵");
        userMapper.updateById(user);

    }

    @Test
    public void deleteTest(){
        User user = userMapper.selectById(1668811294356025345L);
        userMapper.deleteById(user);
    }

}
