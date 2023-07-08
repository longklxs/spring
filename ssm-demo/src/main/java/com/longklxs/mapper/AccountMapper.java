package com.longklxs.mapper;



import com.longklxs.domain.Account;

import java.util.List;

public interface AccountMapper {
    Account findByName(String name);

    List<Account> findAll();

    void update(Account account);



}
