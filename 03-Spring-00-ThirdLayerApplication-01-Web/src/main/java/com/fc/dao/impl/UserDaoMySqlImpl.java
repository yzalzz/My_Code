package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoMySqlImpl implements UserDao {
    @Override
    public void useJdbc() {
        System.out.println("MySql....");
    }
}
