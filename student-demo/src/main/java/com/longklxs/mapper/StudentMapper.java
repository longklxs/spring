package com.longklxs.mapper;

import com.longklxs.domain.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> selectAll();

    public Student selectById(String id);

    public void update(Student student);
    public void insert(Student student);

    public void delete(String id);
}
