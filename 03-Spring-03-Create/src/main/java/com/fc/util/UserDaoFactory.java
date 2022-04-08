package com.fc.util;

import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    private UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
