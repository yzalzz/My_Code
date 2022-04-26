package com.fc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile("product") //条件装配  如果当前使用的是生产环境就会配置这个类的对象到容器中
@Data
@Component
@ConfigurationProperties("person")
public class GrandPa {
    private String name;
    private Integer age;
}
