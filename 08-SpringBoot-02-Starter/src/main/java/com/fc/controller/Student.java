package com.fc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("student")
public class Student {
    @Value("${student.name}")
    private String name;
    @RequestMapping("name")
    public Map<String,Object> testYml(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name",name);
        return map;
    }
}
