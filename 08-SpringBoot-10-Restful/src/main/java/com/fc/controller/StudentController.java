package com.fc.controller;

import com.fc.entity.Student;
import com.github.pagehelper.PageInfo;
import com.fc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public PageInfo<Student> findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize) {
        return studentService.findAll(pageNum, pageSize);
    }
        //restful写法
    @PostMapping("{name}/{age}/{gender}/{info}")
    public Map<String, Object> add(Student student) {
        int affect = studentService.add(student);
        Map<String, Object> map = new HashMap<>();
        if (affect > 0) {
            map.put("code", 200);
            map.put("success", true);
            map.put("message", 6666);
            map.put("data", student);
        } else {
            map.put("code",400 );
            map.put("success", false);
            map.put("message", 5555);
            map.put("data", null);
        }
        return map;
    }
    @PostMapping("{id}/{info}")
    public Map<String,Object> update(Student student){
        int affect = studentService.update(student);
        Map<String, Object> map = new HashMap<>();
        if (affect > 0) {
            map.put("code", 200);
            map.put("success", true);
            map.put("message", 6666);
            map.put("data", student);
        } else {
            map.put("code",400 );
            map.put("success", false);
            map.put("message", 5555);
            map.put("data", null);
        }
        return map;
    }
    @DeleteMapping("{id}")
    public Map<String,Object> delete(@PathVariable("id") Integer id){
        int affect = studentService.delete(id);
        Map<String, Object> map = new HashMap<>();
        if (affect > 0) {
            map.put("code", 200);
            map.put("success", true);
            map.put("message", 6666);
            map.put("data","");
        } else {
            map.put("code",400 );
            map.put("success", false);
            map.put("message", 5555);
            map.put("data", "");
        }
        return map;
    }

}

