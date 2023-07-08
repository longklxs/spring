package com.longklxs;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.longklxs.domain.User;
import com.longklxs.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WrapperTest {

    @Autowired
    UserMapper userMapper;
    @Test
    public void selectOne(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("name","snake");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }
}
