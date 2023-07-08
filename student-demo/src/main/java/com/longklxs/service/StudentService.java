package com.longklxs.service;

import com.github.pagehelper.PageInfo;
import com.longklxs.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(String id);

    void modify(Student student);

    void save(Student student);

    void remove(String id);

    PageInfo<Student> findPage(Integer pageNum, Integer pageSize);

}
