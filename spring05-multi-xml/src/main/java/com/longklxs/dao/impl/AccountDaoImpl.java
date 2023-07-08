package com.longklxs.dao.impl;

import com.longklxs.dao.AccountDao;
import com.longklxs.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;




public class AccountDaoImpl implements AccountDao {




    JdbcTemplate jdbcTemplate;

    @Override
    public Account findByName(String name) {

        List<Account> list = jdbcTemplate.query(" select * from account where name = ? ", new BeanPropertyRowMapper<>(Account.class),name);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update(" update account set name = ?, money = ? where id = ? ", account.getName(),account.getMoney(),account.getId());
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
