package com.longklxs.service;

import com.longklxs.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    void transfer(String sourceName, String targetName,Double money);
}
