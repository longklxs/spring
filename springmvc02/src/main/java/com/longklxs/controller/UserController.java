package com.longklxs.controller;

import com.longklxs.commons.CustomerException;
import com.longklxs.commons.ResultInfo;
import com.longklxs.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/save")
    public ResultInfo save(User user){
        if(user.getUsername() == null || "".equals(user.getUsername())){
            throw new CustomerException("用户名不能为空");
        }

        int i = 1/0;

        System.out.println("接收到了请求参数：" + user);
        return new ResultInfo(200,"执行成功",null);
    }
}
