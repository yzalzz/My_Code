package com.fc.test;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testFindAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = applicationContext.getBean(UserDao.class);

        List<User> all = userDao.findAll();

        System.out.println(all);

    }
//    @Test
//    public void test(){
//        //获取spring容器
//       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        UserDao userDao = applicationContext.getBean(UserDao.class);
//
//        List<User> all = userDao.findAll();
//
//        System.out.println(all);
//
//    }
}
