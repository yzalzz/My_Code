package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void useJdbc() {
        System.out.println("使用Jdbc链接数据库，查询");
    }
}
