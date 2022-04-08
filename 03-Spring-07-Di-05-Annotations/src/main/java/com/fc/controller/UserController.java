package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class UserController {
    @Autowired
    //Controller无法直接访问数据库要调用Service
    private UserService userService;

   public List<User> findAll() {
       return userService.findAll();
    }


}
