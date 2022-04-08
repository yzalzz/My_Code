package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    private String sqlSession;
    @Override
    public void add() {
        System.out.println("sqlSession调用了，添加了一个用户。。。。");

    }
public  UserDaoImpl(){

}
    public UserDaoImpl(String sqlSession) {
        this.sqlSession = sqlSession;
    }
}
