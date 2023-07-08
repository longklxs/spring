package com.longklxs.test;

import com.longklxs.service.AccountService;
import com.longklxs.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class AccountServiceTest {

    @Autowired
    AccountService accountService;
    @Test
    public void test01(){
        accountService.transfer("bbb","ccc",100d);

    }

}
