package com.longklxs.controller;


import com.github.pagehelper.PageInfo;
import com.longklxs.commons.ResultInfo;
import com.longklxs.domain.Student;
import com.longklxs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("/findAll")
    public ResultInfo findAllController(){
        List<Student> students = studentService.findAll();
        return new ResultInfo(200,"ok",students);
    }

    @GetMapping("/findById/{id}")
    public ResultInfo findByIdController(@PathVariable String id){
        Student student = studentService.findById(id);
        return new ResultInfo(200,"ok",student);
    }

    @PutMapping("/modify")
    public ResultInfo modify(@RequestBody Student student){
        studentService.modify(student);
        return new ResultInfo(200,"ok",null);
    }

    @PostMapping("/save")
    public ResultInfo save(@RequestBody Student student){
        studentService.save(student);
        return new ResultInfo(200,"ok",null);
    }

    @DeleteMapping("/delete/{id}")
    public ResultInfo delete(@PathVariable String id){
        studentService.remove(id);
        return new ResultInfo(200,"ok",null);
    }

    @GetMapping("/findPage/{pageNum}/{pageSize}")
    public ResultInfo findPageController(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        PageInfo<Student> page = studentService.findPage(pageNum, pageSize);
        return new ResultInfo(200,"ok",page);
    }

}
