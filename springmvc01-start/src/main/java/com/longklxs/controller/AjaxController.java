package com.longklxs.controller;

import com.longklxs.domain.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

    @RequestMapping("/testAjax")
    public String testAjax(String name, Integer age){
        System.out.println(name + "--" + age);
        return "success";
    }


    @RequestMapping("/testAjax2")
    public Student testAjax2(@RequestBody Student student){
        System.out.println(student);
        return student;
    }

}
