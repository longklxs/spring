package com.longklxs.controller;

import com.longklxs.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {


    @RequestMapping("/param1")
    public String param1(String name, Integer age){
        System.out.println(name + "--" + age);
        return "success";
    }

    @RequestMapping("/param2")
    public String param2(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/param3")
    public String param3(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/param4")
    public String param4(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/param5")
    public String param5(User user){
        System.out.println(user);
        return "success";
    }




}
