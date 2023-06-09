package com.longklxs.dao;

import com.longklxs.bean.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public interface AccountDao {
    public Account findAccount(String name);

    public void update(Account account);
}
