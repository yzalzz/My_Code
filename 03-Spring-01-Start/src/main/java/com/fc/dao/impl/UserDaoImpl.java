package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("链接了数据库，执行了JDBC....");
    }
}
