package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
@Controller
public class UserController {
    @RequestMapping("getParam")
    //SpringMvc不需要通过request.getParameter()方法去获取参数 ，可以直接声明在方法上
    public void getParam(String username,String password){
        System.out.println("用户名 ：" + username+ "密码："+password);
    }
}
