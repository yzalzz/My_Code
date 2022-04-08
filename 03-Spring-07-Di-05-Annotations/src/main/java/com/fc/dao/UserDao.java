package com.fc.dao;

import com.fc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//业务层对象
public interface UserDao {
    List<User> findAll();
}
