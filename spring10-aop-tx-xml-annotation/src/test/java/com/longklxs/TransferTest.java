package com.longklxs;


import com.longklxs.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class TransferTest {

    @Autowired
    AccountService accountService;
    @Test
    public void Test01(){
        accountService.transfer("bbb","ccc",100d);
    }
}
