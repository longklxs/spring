package com.longklxs;


import com.longklxs.domain.Account;
import com.longklxs.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceTest {

    private AccountService accountService;

    @Before
    public void init(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        accountService = ac.getBean("accountService", AccountService.class);
    }

    /**
     * 测试根据名称查询
     */
    @Test
    public void testFindByName(){
        Account account = accountService.findByName("aaa");
        System.out.println(account);
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdate(){
        Account account = accountService.findByName("aaa");
        account.setMoney(1234d);
        accountService.update(account);
    }
}
