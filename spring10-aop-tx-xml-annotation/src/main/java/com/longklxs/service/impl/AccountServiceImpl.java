package com.longklxs.service.impl;

import com.longklxs.dao.AccountDao;
import com.longklxs.domain.Account;
import com.longklxs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("accountService")
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;
    @Override
    public void transfer(String source, String target, Double money) {
        Account account1 = accountDao.selectByName(source);
        Account account2 = accountDao.selectByName(target);
        account1.setMoney(account1.getMoney() - money);
        account2.setMoney(account2.getMoney() + money);
        accountDao.update(account1);
        accountDao.update(account2);


    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
