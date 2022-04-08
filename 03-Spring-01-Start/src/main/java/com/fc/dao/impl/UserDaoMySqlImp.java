package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoMySqlImp implements UserDao {
    @Override
    public void findAll() {
        System.out.println("MySql");
    }
}
