package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//此注解相当于@ResponseBody加@Controller 直接将当前类注入到Spring中并且跳过视图解析器
@RequestMapping("Annotation")
public class TestRestController {
    @RequestMapping("getUser")
    public User getUser(){
        User user = new User();
        user.setUsername("张飞");
        user.setPassword("123456");
        return user;

    }
}
