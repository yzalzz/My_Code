package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("userDaoMysqlImpl")
public class UserDaoMysqlImpl implements UserDao {
    @Override

    public List<User> findAll() {

        ArrayList<User> list = new ArrayList<>();

        list.add(new User(4,"易烊千玺1" ,"123456"));
        list.add(new User(5,"迪丽热巴2" ,"123456"));
        list.add(new User(6,"古力娜扎3" ,"123456"));


        return list;
    }
}
