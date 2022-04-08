package com.fc.entity;

public class Student {
    private Integer id;
    private   String name;
    private  Integer age;

    public Student() {
        System.out.println("无参构造被执行。。。。");
    }
    public void begin(){
        System.out.println("每天开心");
    }
    public void end(){
        System.out.println("每天很累");
    }
}
