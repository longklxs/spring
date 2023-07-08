package com.longklxs;

import com.longklxs.domain.Student;
import com.longklxs.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class StudentServiceTest {

    @Autowired
    StudentService studentService;


    @Test
    public void findAllTest(){
        List<Student> students = studentService.findAll();
        students.forEach((student)->{
            System.out.println(student);
        });
    }

    @Test
    public void findByIdTest(){
        Student student = studentService.findById("hm001");
        System.out.println(student);
    }

    @Test
    public void saveTest(){
        studentService.save(new Student("hm100","hh",new Date(),"北京"));
    }

    @Test
    public void modifyTest(){
        studentService.modify(new Student("hm100","hhhh",new Date(),"北京"));
    }

    @Test
    public void removeTest(){
        studentService.remove("hm100");
    }

}
