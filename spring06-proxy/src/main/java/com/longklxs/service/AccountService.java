package com.longklxs.service;

import com.longklxs.bean.Account;

public interface AccountService {

    public Account findAccount(String name);

    public void update(Account account);
}
