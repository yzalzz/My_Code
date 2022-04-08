package com.fc.test;

import com.fc.entity.Car;
import com.fc.entity.Person;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetTest {
  static   ApplicationContext applicationContext =null;
    @BeforeClass //在测试类执行之前执行
    public static void before(){
     applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("获取容器");
    }
    @AfterClass //在方法执行后执行
    public static void after(){
        ( (ClassPathXmlApplicationContext) applicationContext).close();
        System.out.println("关闭容器");
    }
    @Test
    public void test(){


        Car car = applicationContext.getBean("car", Car.class);

        System.out.println(car);

        Person person = applicationContext.getBean("person", Person.class);

        System.out.println(person);
    }
}
