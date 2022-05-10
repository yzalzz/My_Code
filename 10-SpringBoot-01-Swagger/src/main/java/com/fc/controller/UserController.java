package com.fc.controller;

import com.fc.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@Api(tags = "用户处理器",description = "用户相关的所有操作")//sagger注解类上
public class UserController {
    @GetMapping("findAll")
    @ApiOperation(value = "查询所有用户",nickname = "查询所有用户")//sagger注解方法上
    public Map<String ,Object> findALl(){

        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("message","成功");
        map.put("success",true);
        map.put("data",new User(1,"YZA","123456"));

        return map;
    }
    @PutMapping("update")
    @ApiOperation("修改用户")
    public String update(){
        return "修改成功";
    }
    @DeleteMapping("delete")
    @ApiOperation("删除用户")
    public String Delete(@ApiParam(name="id",value ="用户编号" ,defaultValue = "默认值为100，能够查询id为1的用户"
    ,example = "100",
    allowableValues = "range[1,100]")
                         @RequestParam Integer id){
        System.out.println("delete user "+ id);
        return "删除成功"+id;
    }
    @PostMapping("add")
    @ApiOperation("添加用户")
    public String add(){
        return "添加成功";
    }
    @GetMapping("getUser")
    @ApiOperation("获取学生")
    public User getUser(){
        return new User(1,"555","222");
    }

}
