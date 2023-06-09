package com.longklxs;


import com.longklxs.bean.Account;
import com.longklxs.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class SpringTest {

    @Qualifier("proxy")
    @Autowired
    AccountService accountService;


    @Test
    public void findTest(){
        Account account = accountService.findAccount("aaa");
        System.out.println(account);
    }

    @Test
    public void updateTest(){
        Account account = accountService.findAccount("aaa");
        account.setMoney(123d);
        accountService.update(account);
    }


}
