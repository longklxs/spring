package com.longklxs.web.controller;


import com.alibaba.fastjson.JSON;
import com.longklxs.commons.Constant;
import com.longklxs.commons.ResultInfo;
import com.longklxs.domain.User;
import com.longklxs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @CacheEvict(value = Constant.USERALL_CACHE,key = "'all'")
    @RequestMapping("/user/save")
    public ResultInfo save(@RequestBody User user){
        userService.save(user);
        return ResultInfo.success(user);
    }

    @Cacheable(value = Constant.USERALL_CACHE,key = "'all'")
    @RequestMapping("/user/findAll")
    public ResultInfo findAll(){
        List<User> userList = userService.findAll();
        return ResultInfo.success(userList);
    }


    @RequestMapping("/user/update")
    public ResultInfo update(User user){
        userService.update(user);
        return ResultInfo.success(null);
    }

    @RequestMapping("/user/delete")
    public ResultInfo delete(Long id){
        userService.delete(id);
        return ResultInfo.success(null);
    }

    public ResultInfo findById(Long id){
        User user = userService.findById(id);
        return ResultInfo.success(user);
    }

}
