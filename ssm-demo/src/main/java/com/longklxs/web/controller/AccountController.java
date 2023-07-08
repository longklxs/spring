package com.longklxs.web.controller;

import com.longklxs.commons.ResultInfo;
import com.longklxs.domain.Account;
import com.longklxs.mapper.AccountMapper;
import com.longklxs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;
    @RequestMapping("/findAll")
    public ResultInfo findAll(){
        System.out.println("执行了查询所有");
        List<Account> accounts = accountMapper.findAll();
        return new ResultInfo(200,"ok",accounts);
    }
}
