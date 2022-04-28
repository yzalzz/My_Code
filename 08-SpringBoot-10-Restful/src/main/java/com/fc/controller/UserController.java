package com.fc.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;
//需要在yml文件里配置
@RestController
@RequestMapping("user")
public class UserController {
    @PostMapping("{username}/{password}")
    //@PathVariable此注解用来对Restful风格进行参数绑定
    public String add(@PathVariable("username") String username,@PathVariable("password") String password){
        return "添加操作被执行"+username+password;
    }
    @GetMapping()
    //@PathVariable此注解用来对Restful风格进行参数绑定
    public String query(){
        return "查询操作被执行";
    }
    @PutMapping("{id}/{username}/{password}")
    //@PathVariable此注解用来对Restful风格进行参数绑定
    public String put(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("id") Integer id){
        return "修改操作被执行"+username+password+id;
    }
    @DeleteMapping("{id}")
    //@PathVariable此注解用来对Restful风格进行参数绑定
    public String delete(@PathVariable("id") Integer id){
        return "删除操作被执行"+id;
    }
}
