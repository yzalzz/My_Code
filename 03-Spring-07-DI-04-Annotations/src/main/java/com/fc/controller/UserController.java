package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.service.impl.UserServiceImpl;

import java.util.List;

public class UserController {
    //Controller无法直接访问数据库要调用Service
    private UserService userService;

   public List<User> findAll() {
       return userService.findAll();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
