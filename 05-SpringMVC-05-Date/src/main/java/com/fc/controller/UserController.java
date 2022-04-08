package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {
    //用String 来接受日期 String是用"-" 作为分隔符
    // 浏览器提交的Date类型数据把"-"作为分隔符 而我们需要"/" 作为分隔符 需要转换
    @RequestMapping("getString")
    private void getString(String date){
        System.out.println(date);
    }
    //用Date来接受日期 用Date必须用"/"作为分隔符
    @RequestMapping("getDate")
    private void getDate(Date date){
        System.out.println(date);
    }
}
