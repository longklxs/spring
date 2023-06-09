package com.longklxs.controller;

import com.longklxs.commons.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InterceptorDemoController {

    @RequestMapping("/testInterceptor")
    public ResultInfo testInterceptor(){
        System.out.println("控制器方法执行");
        return new ResultInfo(200,"success",null);
    }
}
