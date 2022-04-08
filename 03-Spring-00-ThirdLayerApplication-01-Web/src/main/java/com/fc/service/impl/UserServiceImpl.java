package com.fc.service.impl;

import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;
import com.fc.dao.impl.UserDaoMySqlImpl;
import com.fc.service.UserServiceDao;

public class UserServiceImpl implements UserServiceDao {
    //多态 父类引用指向子类对象（接口引用指向接口的实现类）
    private UserDao userDao=new com.fc.dao.impl.UserDao();

    @Override
    public void useJdbc() {
    userDao.useJdbc();
    }
}
