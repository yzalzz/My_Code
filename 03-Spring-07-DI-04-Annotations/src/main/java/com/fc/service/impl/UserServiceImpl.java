package com.fc.service.impl;

import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;
import com.fc.entity.User;
import com.fc.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    //业务层无法直接访问数据库 要通过Dao去访问
private UserDao userDao;
    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        return list;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
