package com.fc.test;

import com.fc.entity.Car;
import com.fc.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorTest {
    @Test
    public void testConstructor(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = applicationContext.getBean("car1", Car.class);

        System.out.println(car);

        Person person = applicationContext.getBean("person", Person.class);

        System.out.println(person);

    }
}
