package com.fc.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;
@PropertySource("classpath:jdbc.properties") //将指定路径下的配置文件加载进来
@ComponentScan("com.fc")  //扫描当前包下的所有注解
@Configuration //声明此注解 说明这是一个配置类 用来替代配置文件
public class ApplicationContextConfig {
    //数据源
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String  username;
    @Value("${jdbc.password}")
    private String  password;
@Bean("jdbcTemplate")//将当前方法的返回值注入
public JdbcTemplate getJdbcTemplate(){
    JdbcTemplate jdbcTemplate=null;
    try {
        Properties properties = new Properties();
        properties.setProperty("driverClassName",driverClassName);
        properties.setProperty("url",url);
        properties.setProperty("username",username);
        properties.setProperty("password",password);
        //获取数据源
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //设置jdbcTemplate的数据源
       jdbcTemplate = new JdbcTemplate(dataSource);

    } catch (Exception e) {
        e.printStackTrace();
    }
    return jdbcTemplate;
}

}


//// 将指定路径下的配置文件加载进来
//@PropertySource("classpath:jdbc.properties")
//@ComponentScan("com.fc")
//// 声明了此注解，说明当前类是一个配置类，替换掉配置文件
//@Configuration
//@PropertySource("classpath: jdbc.properties")
//@ComponentScan
//@Configuration //声明此注解说明当前类是一个配置类，替换掉配置文件
//public class ApplicationContextConfig {
//    @Value("${jdbc.driver}")
//    private String driverClassName;
//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${jdbc.password}")
//    private String password;




















//    @Value("${jdbc.driver}")
//    private String driverClassName;
//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${jdbc.password}")
//    private String password;
//
//    // @Bean注解用于将当前方法的返回值放到容器中
//    @Bean("jdbcTemplate")
//    public JdbcTemplate getJdbcTemplate() {
//        JdbcTemplate jdbcTemplate = null;
//
//        try {
//            Properties properties = new Properties();
//
//            properties.setProperty("driverClassName", driverClassName);
//            properties.setProperty("url", url);
//            properties.setProperty("username", username);
//            properties.setProperty("password", password);
//
//            DataSource dataSource;
//
//            //要拿到jdbcTemplate就必须配置数据源
//            //获取数据源必须从DruidDataSourceFactory工厂里获取  工厂里必须有一个properties对象
//            dataSource = DruidDataSourceFactory.createDataSource(properties);
//
//            jdbcTemplate = new JdbcTemplate(dataSource);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return jdbcTemplate;
//    }
//}
