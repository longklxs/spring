package com.longklxs.web.controller;


import com.alibaba.fastjson.JSON;
import com.longklxs.commons.Constant;
import com.longklxs.commons.ResultInfo;
import com.longklxs.domain.User;
import com.longklxs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @RequestMapping("/user/save")
    public ResultInfo save(@RequestBody User user){
        userService.save(user);
        redisTemplate.delete(Constant.USERALL_CACHE);
        return ResultInfo.success(null);
    }

    @RequestMapping("/user/findAll")
    public ResultInfo findAll(){
        String users = (String) redisTemplate.opsForValue().get(Constant.USERALL_CACHE);

        if(users != null){
            List<User> lists = JSON.parseArray(users,User.class);
            System.out.println("从缓存中获取的数据：" + lists);
            return ResultInfo.success(lists);
        }else{
            List<User> userList = userService.findAll();
            String json = JSON.toJSONString(userList);
            redisTemplate.opsForValue().set(Constant.USERALL_CACHE,json);
            System.out.println("从数据库获取:" + userList);
            return ResultInfo.success(userList);
        }
    }


    @RequestMapping("/user/update")
    public ResultInfo update(User user){
        userService.update(user);
        redisTemplate.delete(Constant.USERALL_CACHE);
        return ResultInfo.success(null);
    }

    @RequestMapping("/user/delete")
    public ResultInfo delete(Long id){
        userService.delete(id);
        redisTemplate.delete(Constant.USERALL_CACHE);
        return ResultInfo.success(null);
    }

    public ResultInfo findById(Long id){
        String userJson = (String)redisTemplate.opsForValue().get(Constant.SINGLEUSER_PREFIX_CACHE + id);
        if(userJson != null){
            System.out.println("从缓存中获取的：" + userJson);
            User userObject = JSON.parseObject(userJson,User.class);
            return ResultInfo.success(userObject);
        }else{
            User user = userService.findById(id);
            String json = JSON.toJSONString(user);
            redisTemplate.opsForValue().set(Constant.SINGLEUSER_PREFIX_CACHE + id,json);
            System.out.println("从数据库中获取的：" + json);
            return ResultInfo.success(user);
        }
    }

}
