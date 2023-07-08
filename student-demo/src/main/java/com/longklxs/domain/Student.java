package com.longklxs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private String id;
    private String name;


    @JsonFormat(pattern = "yyyy-MM-ss")
    private Date birthday;
    private String address;
}
