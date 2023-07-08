package com.longklxs.controller;



import com.longklxs.commons.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/findAll")
    public ResultInfo findAll(){
        log.info("调试");
        System.out.println("查询所有");
        return ResultInfo.success(null);
    }
}
