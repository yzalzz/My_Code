package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {
    //value 和 path 属性一样 不能同时使用
    //method 指定该方法的请求方式 如果不写可以为任意类型
    @RequestMapping(headers = "zz",value = {"getParam","getParam1","getParam2"})
    public void getParam(String username,String password){
        System.out.println("用户名："+username+"密码："+password);
    }

}
