package com.longklxs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longklxs.domain.Student;
import com.longklxs.mapper.StudentMapper;
import com.longklxs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<Student> findAll() {

        return studentMapper.selectAll();
    }

    @Override
    public Student findById(String id) {
        return studentMapper.selectById(id);
    }

    @Override
    public void modify(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void save(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void remove(String id) {
        studentMapper.delete(id);
    }

    @Override
    public PageInfo<Student> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentMapper.selectAll();
        return new PageInfo<Student>(students);
    }
}
