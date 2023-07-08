package com.longklxs.web.controller;

import com.longklxs.commons.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/info")
    public ResultInfo info(){
        return ResultInfo.success(null);
    }

    @RequestMapping("/fail")
    public  ResultInfo fail(){
        return ResultInfo.error(null);
    }


}
