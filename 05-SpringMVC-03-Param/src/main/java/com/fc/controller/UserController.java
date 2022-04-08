package com.fc.controller;

import com.fc.entity.ComplexType;
import com.fc.entity.User;
import com.fc.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RequestMapping("user")
@Controller
public class UserController {
    @RequestMapping("register")
    public String register(String name, Integer age, String gender, String birthday, String info) {
        System.out.println(name + " " + age + "" + gender + "" + birthday + " " + info);

        // 页面跳转路径
        return "/success.jsp";
    }

    @RequestMapping("getBean")
    public String getBean(User user) {
        System.out.println(user);

        return "/success.jsp";
    }

    //对象里面包含一个对象
    @RequestMapping("getNestedBean")
    public String getNestedBean(UserInfo userInfo) {
        System.out.println(userInfo);

        return "/success.jsp";
    }
//复杂类型参数 数组 list[0].username   map 键值对:map['user1'].name
    @RequestMapping("ListAndMap")
    public String ListAndMap(ComplexType complexType) {
        System.out.println(complexType);
        return "/success.jsp";

    }
}
