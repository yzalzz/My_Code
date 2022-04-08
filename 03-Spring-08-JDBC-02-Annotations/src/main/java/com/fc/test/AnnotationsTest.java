package com.fc.test;


import com.fc.config.ApplicationContextConfig;
import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AnnotationsTest {
    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int affectedRows = userDao.delete(1);

        System.out.println(affectedRows);
    }

    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int affectedRows = userDao.update(new User(1, null, "888"));

        System.out.println(affectedRows);
    }
    @Test
    public void testCount(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao bean = applicationContext.getBean(UserDao.class);

        int count = bean.Count();

        System.out.println(count);
    }
    @Test
    public void testFindById(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao bean = applicationContext.getBean(UserDao.class);

        User byId = bean.findById(1);

        System.out.println(byId);

    }
    @Test
    public void testFindAll() {
        //AnnotationConfigApplicationContext  通过注解
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDaoImpl.class);

        List<User> users = userDao.findAll();

        System.out.println(users);
    }
}
