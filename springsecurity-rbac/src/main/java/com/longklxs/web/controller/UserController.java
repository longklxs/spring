package com.longklxs.web.controller;

import com.longklxs.commons.ResultInfo;
import com.longklxs.pojo.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sys/user")
public class UserController {

    @RequestMapping("/list")
    @Secured({"ROLE_超级管理员"})
    public ResultInfo list(){
        List<Users> users = new ArrayList<>();
        return ResultInfo.success("列表");
    }

    @RequestMapping("/add")
    @PreAuthorize("hasAuthority('sys:user:add')")
    public ResultInfo add(){
        return ResultInfo.success("添加");
    }
}
