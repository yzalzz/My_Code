package com.fc.config;

import com.fc.entity.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //声明此注解说明当前类是一个配置类
// @ConditionalOnBean 条件装配 满足进行装配 不满足不装配
public class BeanConfig {
    @Bean("car")
    //必须满足这两条件才能进行装配
    @ConditionalOnBean(Person.class)
    @ConditionalOnMissingBean(Bike.class)
    public Car getCar(){
        return new Car();
    }











    @Bean("wife") //将当前方法的返回值注入到容器中，此注解只能用在方法上
    public Wife getWife(){
        return new Wife();
    }
    @Bean("son")
    @ConditionalOnBean(Wife.class)  //只有容器中有指定的对象（Wife.class）是才满足条件进行装配
    public Son getSon(){
        return new Son();
    }
    @Bean("girl")
    @ConditionalOnMissingBean(Wife.class) //只有容器中没有指定的对象（Wife.class）是才满足条件进行装配
    public GirlFriend getGirlFriend(){
        return new GirlFriend();
    }
}
