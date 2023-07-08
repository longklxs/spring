package com.longklxs.mapper;

import com.longklxs.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> selectAll();

}
