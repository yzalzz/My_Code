package com.fc.controller;

import com.fc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("test")
    public String test(){
        return "hello";
    }

}
