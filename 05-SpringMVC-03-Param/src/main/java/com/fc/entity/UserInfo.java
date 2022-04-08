package com.fc.entity;

import lombok.Data;

@Data
public class UserInfo {
    private String username;
    private String password;
    //对象里面包含一个对象 ( UserInfo包含一个user)
    private User user;
}
