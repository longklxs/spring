package com.longklxs.dao;

import com.longklxs.domain.Account;

public interface AccountDao {

    public Account selectByName(String name);

    public void update(Account account);
}
