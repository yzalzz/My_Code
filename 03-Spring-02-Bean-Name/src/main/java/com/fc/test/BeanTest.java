package com.fc.test;

import com.fc.entity.Student;
import lombok.Data;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Object bean = applicationContext.getBean("student3");

        Student student=(Student) bean;

        System.out.println(bean);

    }
}
