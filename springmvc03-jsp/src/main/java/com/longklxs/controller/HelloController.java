package com.longklxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(HttpServletRequest request, HttpServletResponse response){
        System.out.println("HelloController的sayHello方法执行了");
        return "success";
    }
    @RequestMapping("/user/list")
    public String userList(HttpServletRequest request, HttpServletResponse response){
        System.out.println("HelloController的userList方法执行了");
        return "forward:/WEB-INF/page/user/list.jsp";
    }

    @RequestMapping("/info")
    public String info(HttpServletRequest request, HttpServletResponse response){
        System.out.println("HelloController的info方法执行了");
        return "forward:/info.jsp";
    }

    @RequestMapping("/info2")
    public String info2(HttpServletRequest request, HttpServletResponse response){
        System.out.println("HelloController的info方法执行了");
        return "redirect:/info.jsp";
    }
}
