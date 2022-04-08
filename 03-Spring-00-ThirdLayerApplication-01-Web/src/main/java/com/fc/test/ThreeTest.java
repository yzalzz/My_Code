package com.fc.test;

import com.fc.service.UserServiceDao;
import com.fc.service.impl.UserServiceImpl;
import org.junit.Test;

public class ThreeTest {
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();

        userService.useJdbc();

    }
}
