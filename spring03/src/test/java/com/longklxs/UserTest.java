package com.longklxs;

import com.longklxs.service.UserService;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void Test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        System.out.println(userService);
    }
}
