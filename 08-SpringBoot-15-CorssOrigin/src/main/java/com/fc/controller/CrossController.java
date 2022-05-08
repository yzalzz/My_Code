package com.fc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cross")
//@CrossOrigin("http://127.0.0.1:8848/") //跨域注解 不写默认所有源都支持 ，写上只支持写上的源，可以写多个
//@CrossOrigin(originPatterns = "http://127.0.0.1:*") //当前主机下所有源都能访问
//originPatterns = "*", allowCredentials = "true",它俩冲突 不能同时写
@CrossOrigin(maxAge = 3600,methods = {
        RequestMethod.DELETE,
        RequestMethod.GET,
        RequestMethod.OPTIONS,
        RequestMethod.POST,
        RequestMethod.PUT
})
//如果我们使用了自定义的请求头 此次请求是一个复杂请求 分为2部分 预检请求 和真实请求 复杂请求必须经过预检
//简单请求： 请求方式必须为HEAD,post,get  不能使用自定义的请求头
public class CrossController {
    @GetMapping("test")
    public String test(){
        return "哈哈";
    }
}
