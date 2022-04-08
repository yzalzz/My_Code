package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void testScope(){
        //获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student =  applicationContext.getBean("student", Student.class);

        Student student1 = applicationContext.getBean("student",Student.class);

        System.out.println(student==student1);


    }
}
