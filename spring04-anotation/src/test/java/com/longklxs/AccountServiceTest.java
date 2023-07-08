package com.longklxs;

import com.longklxs.config.SpringConfig;
import com.longklxs.domain.Account;
import com.longklxs.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;


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
