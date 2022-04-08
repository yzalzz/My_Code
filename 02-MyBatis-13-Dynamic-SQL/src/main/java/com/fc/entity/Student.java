package com.fc.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Date birthday;
    private String info;
}
