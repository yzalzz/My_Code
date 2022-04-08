package com.fc.test;

import com.fc.controller.UserController;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Annotations {
     @Test
    public void test(){

         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

         UserController userController = applicationContext.getBean("userController", UserController.class);

         List<User> users = userController.findAll();

         System.out.println(users);

     }

}
