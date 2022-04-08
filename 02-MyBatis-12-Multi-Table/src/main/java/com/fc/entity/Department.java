package com.fc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private Integer id;
    private String name;
    //一对多
    //一个部门可以对应多个员工
    //这样写可以查出员工表中的员工信息
    private List<Employee> employees;
}
