package com.longklxs.service.impl;

import com.longklxs.service.UserService;

import org.springframework.stereotype.Component;



public class UserServiceImpl implements UserService {

    @Override
    public void saveUser() {
        System.out.println("保存用户");
    }

    @Override
    public void update(int i) {
        System.out.println("更新用户" + i);
    }

    @Override
    public int delete() {
        System.out.println("删除用户");
        return 10;
    }
}
