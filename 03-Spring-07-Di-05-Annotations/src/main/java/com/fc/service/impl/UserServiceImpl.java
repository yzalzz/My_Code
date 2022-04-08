package com.fc.service.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    //业务层无法直接访问数据库 要通过Dao去访问
    @Resource(name="userDaoMysqlImpl")
//    @Autowired
//    @Qualifier("userDaoMysqlImpl")
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
