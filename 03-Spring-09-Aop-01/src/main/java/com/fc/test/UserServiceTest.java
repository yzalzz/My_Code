package com.fc.test;

import com.fc.Service.Impl.UserServiceImpl;
import com.fc.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService bean = applicationContext.getBean(UserService.class);

        bean.add();
        System.out.println("-------------------------------");
        bean.update();

    }
}
