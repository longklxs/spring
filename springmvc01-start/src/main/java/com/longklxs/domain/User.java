package com.longklxs.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Data
public class User implements Serializable {
    private String name;
    private Integer age;
    private Date birthday;
    private Address address;
    private List<String> list;
    private Map<String,String> map;
}
