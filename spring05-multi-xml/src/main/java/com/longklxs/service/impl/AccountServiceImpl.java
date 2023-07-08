package com.longklxs.service.impl;

import com.longklxs.dao.AccountDao;
import com.longklxs.domain.Account;
import com.longklxs.service.AccountService;


public class AccountServiceImpl implements AccountService {


    AccountDao accountDao;

    @Override
    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
