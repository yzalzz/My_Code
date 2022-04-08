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
    //多对多一名学生可以对应多门学科
    private List<Subject> subjects;
}
