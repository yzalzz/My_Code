package com.fc.entity;

public class Student {
    private Integer id;
    private  String name;
    private Integer age;
    //默认为使用无参构造创建Bean

    public Student() {
        System.out.println("无参构造被执行...");
    }
}
