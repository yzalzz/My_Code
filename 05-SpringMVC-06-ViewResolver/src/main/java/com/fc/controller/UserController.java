package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("hello")
    public String hello(){
        System.out.println("Hello");
        return "hello";
    }
    //这样写会写很多重复的前缀和后缀 配置试图解析器会解决这个问题
    @RequestMapping("login")
    public String login(){
        System.out.println("登录");
        return "login";
    }
    @RequestMapping("add")
    public String add(){
        System.out.println("add");
        return "add";
    }
    @RequestMapping("delete")
    public String delete(){
        System.out.println("delete");
        return "delete";
    }
    @RequestMapping("update")
    public String update(){
        System.out.println("update");
        return "update";
    }
}
