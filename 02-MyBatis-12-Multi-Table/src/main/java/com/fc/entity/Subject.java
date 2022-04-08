package com.fc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Subject {
    private Integer id;
    private String name;
    //多对多，一门学科可以对应多名学生
    private List<Student> students;
}
