package com.longklxs.test;


import com.longklxs.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03SpringMybatis {

    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        AccountService accountService = ac.getBean("accountServiceImpl", AccountService.class);
        System.out.println(accountService.findAll());

    }
}
