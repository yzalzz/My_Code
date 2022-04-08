package com.fc.test;

import com.fc.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateTest {
    @Test
    public void test() {
        //获取一个容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

        userDao.add();


    }

    @Test
    public void testFactory() {
        //获取一个容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//
        UserDao userDao = applicationContext.getBean("userDao2", UserDao.class);

        userDao.add();


    }
    @Test
    public void testStaticFactory() {
        //获取一个容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//
        UserDao userDao = applicationContext.getBean("userDao3", UserDao.class);

        userDao.add();


    }
}
