package com.fc;

import com.fc.entity.Car;
import com.fc.entity.GirlFriend;
import com.fc.entity.Son;
import com.fc.entity.Wife;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //获取spring容器
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        //如果容器里有就获取
        if (applicationContext.containsBean("son")){
            //获取容器对象
            Son son = applicationContext.getBean(Son.class);
            System.out.println("有儿子"+son);
        }else {
            System.out.println("没有儿子");
        }

        if (applicationContext.containsBean("wife")){
            //获取容器对象
            Wife wife = applicationContext.getBean(Wife.class);
            System.out.println("有老婆"+wife);
        }else {
            System.out.println("没有老婆");
        }
        if (applicationContext.containsBean("girl")){
            //获取容器对象
           GirlFriend girlFriend = applicationContext.getBean(GirlFriend.class);
            System.out.println("有女朋友"+girlFriend);
        }else {
            System.out.println("没有女朋友");
        }


        System.out.println(applicationContext.getBean(Car.class));

    }

}
