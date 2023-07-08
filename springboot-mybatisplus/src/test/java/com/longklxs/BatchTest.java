package com.longklxs;


import com.longklxs.domain.User;
import com.longklxs.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BatchTest {

    @Autowired
    UserMapper userMapper;
    @Test
    public void selectBatchTest(){

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach((u) -> {
            System.out.println(u);
        });
    }

    @Test
    public void deleteBatchTest(){
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        userMapper.deleteBatchIds(ids);
    }
}
