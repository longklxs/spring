package com.longklxs.service.impl;

import com.longklxs.bean.User;
import com.longklxs.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class UserServiceImpl implements UserService {

    private String name;
    private User user;

    private List<String> list;

    private Set<String> set;
    private Properties properties;

    private Map<String,String> map;


    @Override
    public void saveUser() {
        System.out.println(name);
        System.out.println(user);
        System.out.println(list);
        System.out.println(set);
        System.out.println(properties);
        System.out.println(map);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
