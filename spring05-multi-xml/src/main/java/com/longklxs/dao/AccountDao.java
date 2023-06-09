package com.longklxs.dao;

import com.longklxs.domain.Account;

public interface AccountDao {
    Account findByName(String name);

    void update(Account account);

}
