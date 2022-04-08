package com.fc.test;

import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;
import com.fc.dao.impl.UserDaoOracleImpl;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTest {
    @Test
    public void test(){
        //获取spring容器
       ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取Bean对象
        UserDao userDao = ApplicationContext.getBean("userDao", UserDao.class);

        userDao.findAll();


    }
}
