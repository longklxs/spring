package com.longklxs.service.impl;

import com.longklxs.domain.Account;
import com.longklxs.mapper.AccountMapper;
import com.longklxs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    @Override
    public void transfer(String sourceName, String targetName,Double money) {
        Account source = accountMapper.findByName(sourceName);

        Account target = accountMapper.findByName(targetName);

        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        accountMapper.update(source);
        accountMapper.update(target);


    }
}
