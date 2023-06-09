package com.longklxs.service.impl;

import com.longklxs.bean.Account;
import com.longklxs.dao.AccountDao;
import com.longklxs.service.AccountService;

public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    public Account findAccount(String name){
        return accountDao.findAccount(name);
    }

    public void update(Account account){
        accountDao.update(account);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
