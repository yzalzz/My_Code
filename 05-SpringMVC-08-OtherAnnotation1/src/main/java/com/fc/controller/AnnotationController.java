package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("annotation")

public class AnnotationController {
    @RequestMapping("testRequestParam")
    //@RequestParam注解 defaultValue默认值
    public String testRequestParam(@RequestParam(value = "userId",required = false,defaultValue = "1") String id){
        System.out.println("前端输入数据"+id);
        return "/success.jsp";
    }
    @RequestMapping("page")
    // //@RequestParam注解 defaultValue默认值可以用来做分页
    public String page(@RequestParam(value = "pageNo" ,defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        System.out.println("当前页"+pageNo+"每页多少数据"+pageSize);

        return "/success.jsp";
    }




    //@PathVariable 可以实现url地址栏RESTful风格  GET查找 ，PUT增加 DELETE删除 POST修改
    @GetMapping(value = "user/{id}")
    @ResponseBody
    public String  getUser(@PathVariable("id") String id){
        System.out.println("查询id为"+id+"学生");
        return "查询id为"+id+"学生";
    }
    @DeleteMapping (value = "user/{id}")
    @ResponseBody
    public String  getDelete(@PathVariable("id") String id){
        System.out.println("删除id为"+id+"学生");
        return "删除id为"+id+"学生";
    }
    //@PathVariable 可以实现url地址栏RESTful风格
    @PutMapping(value = "user/{id}")
    @ResponseBody
    public String  UpdateUser(@PathVariable("id") String id){
        System.out.println("修改id为"+id+"学生");
        return"修改id为"+id+"学生";
    }
    @PostMapping(value = "user/{id}")
    @ResponseBody
    public String  insertDelete(@PathVariable("id") String id){
        System.out.println("插入id为"+id+"学生");
        return "插入id为"+id+"学生";
    }
    //@RequestBody 此注解从前端获取json数据

    //@ResponseBody 响应json数据
    @RequestMapping("testRequestBody")
    @ResponseBody
public String testRequestBody(@RequestBody String json){
        System.out.println(json);
        return json;

}
@RequestMapping("getUser")
@ResponseBody
private void getUser(@RequestBody User user){
    System.out.println(user);
}





}
