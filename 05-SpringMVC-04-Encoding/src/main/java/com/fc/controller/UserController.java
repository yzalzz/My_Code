package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//get请求一般不会乱码 只有post会乱码 可以通过配置解决

@RequestMapping("user")
@Controller
public class UserController {
    @RequestMapping("register")
    public String register(User user){
        System.out.println(user);

        return "/success.jsp";

    }
}
