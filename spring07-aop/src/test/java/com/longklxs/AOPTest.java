package com.longklxs;


import com.longklxs.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class AOPTest {

    @Autowired
    UserService userService;

    @Test
    public void test01(){
//        userService.saveUser();
        userService.update(10);
//        userService.delete();
    }
}
