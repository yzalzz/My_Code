package com.fc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "student")//@ConfigurationProperties能够将整个配置文件映射成一个类的对象，适用于自定义配置比较多的情况如果使用了这个注解，要求当前类必须在容器中
public class Student {
    private String name;
    private Integer age;
    private String gender;
    private Date birthday;
    private Boolean married;
    private String[] hobby;
    private List<String> food;
    private Map<String, Object> score;
    private Car car;
}
