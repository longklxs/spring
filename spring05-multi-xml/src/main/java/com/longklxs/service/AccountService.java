package com.longklxs.service;

import com.longklxs.domain.Account;

public interface AccountService {
    Account findByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void update(Account account);
}
