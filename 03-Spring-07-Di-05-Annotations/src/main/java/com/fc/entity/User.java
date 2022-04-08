package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//实体类 PO 对应持久层
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    @Value("1")
    private Integer id;
    @Value("小明")
    private String username;
    @Value("123456")
    private String password;

}
