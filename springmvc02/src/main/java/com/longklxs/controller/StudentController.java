package com.longklxs.controller;

import com.longklxs.commons.ResultInfo;
import com.longklxs.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PostMapping
    public ResultInfo save(@RequestBody Student student){
        System.out.println("执行了保存" + student);
        return new ResultInfo(200,"执行成功",null);
    }

    @PutMapping
    public ResultInfo update(@RequestBody Student student){
        System.out.println("执行了更新" + student);
        return new ResultInfo(200,"执行成功",null);
    }

    @DeleteMapping("{id}")
    public ResultInfo delete(@PathVariable Integer id){
        System.out.println("执行了删除，要删除的学生id是：" + id);
        return new ResultInfo(200,"执行成功",null);
    }

    @GetMapping("{id}")
    public ResultInfo findById(@PathVariable Integer id){
        System.out.println("执行了根据id查询，查询的id是：" + id);
        Student student = new Student(1,"老王",20,"男",new Date());
        return new ResultInfo(200,"执行成功",student);
    }

    @GetMapping("page/{keywords}/{pageNum}/{pageSize}")
    public ResultInfo findPage(@PathVariable(required = false) @RequestParam(defaultValue = "1") String keywords,
                               @PathVariable(required = false) @RequestParam(defaultValue = "1")Integer pageNum,
                               @PathVariable(required = false) @RequestParam(defaultValue = "1")Integer pageSize){

//        System.out.println(keywords+","+pageNum+","+pageSize);
        return new ResultInfo(200,"执行成功",null);
    }
}
