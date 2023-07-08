package com.longklxs.web.controller;

import com.longklxs.commons.ResultInfo;
import com.longklxs.domain.Student;
import com.longklxs.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/findAll")
    public ResultInfo findAll(){
        List<Student> students = studentMapper.selectAll();
        return ResultInfo.success(students);
    }

}
