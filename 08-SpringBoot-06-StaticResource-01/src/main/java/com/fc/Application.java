package com.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//优先级 1.META-INF/ 2.resources 3.public 4.static
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
