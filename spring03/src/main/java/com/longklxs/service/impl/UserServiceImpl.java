package com.longklxs.service.impl;

import com.longklxs.dao.UserDao;
import com.longklxs.service.UserService;
import org.springframework.stereotype.Component;

@Component(value = "userService")
public class UserServiceImpl implements UserService {

    UserDao userDao;
    @Override
    public void save() {
        System.out.println("保存");
    }
}
