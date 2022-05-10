package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService service;
    @RequestMapping("findAll")
    public List<Student> findAll(){
        return service.findAll();
    }
    @RequestMapping("findByPage")
    public PageInfo<Student> findByPage(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "3") Integer pageSize){
        // Page会引发循环依赖问题 要配置避免循环依赖问题
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = service.findAll();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }
}
