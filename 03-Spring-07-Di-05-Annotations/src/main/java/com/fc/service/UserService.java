package com.fc.service;

import com.fc.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
