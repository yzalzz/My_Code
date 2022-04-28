package com.fc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@MapperScan("com.fc.dao")//扫描指定包路径下的接口，用于生成对应的代理对象（实现类对象 ） 必须加 要么加这个要么在dao加Mapper
@EnableTransactionManagement //开启事务平台管理器 不加也行
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
