package com.fc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
1.创建一个web项目
2.导入spring-webmvc依赖
3.在web.xml配置前端控制器
4.在springMvc配置文件
5.创建一个类加上@Controller 和 RequestMapping 注解；
6.一个方法就是一个功能 加上@ResquestMapping注解；
 */
@Controller
@RequestMapping("user")//此标签用来声明请求的url路径，也能加/ ,也可以不加
public class UserController {
    //方法上的@RequestMapping，相当于二级路径
    @RequestMapping("login")
    public String login(){
        System.out.println("登录成功");
        //从根路径去找
        return "/login.jsp";
    }
    @RequestMapping("register")
    public String register(){
        System.out.println("注册成功");
        return "/login.jsp";
    }
    @RequestMapping("insert")
    public String insert(){
        System.out.println("插入成功");
        return "/login.jsp";
    }
    @RequestMapping("delete")
    public String delete(){
        System.out.println("删除成功");
        return "/login.jsp";
    }


}
