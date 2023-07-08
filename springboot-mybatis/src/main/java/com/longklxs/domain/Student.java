package com.longklxs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private String id;
    private String name;
    private Date birthday;
    private String address;





}
