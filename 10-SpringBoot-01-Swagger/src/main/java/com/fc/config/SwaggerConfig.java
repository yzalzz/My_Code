package com.fc.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

//@EnableSwagger2 //开启自动装配Swagger 2.10.5没有这个注解
@EnableSwagger2WebMvc //2.10.5 用这个注解
@EnableKnife4j//开启Knife4j 默认就是开启的
//swagger配置类
@Configuration
public class SwaggerConfig {
    //装配Swagger 的Bean对象
    @Bean
    public Docket docket() {
        //创建对象使用Swagger作为文档类型
        return new Docket(DocumentationType.SWAGGER_2)
                //添加API信息
                .apiInfo(apiInfo())
                //允许查看所有的API信息
                .select()
                //指定文档生成的路径
                .apis(RequestHandlerSelectors.basePackage("com.fc"))
                //支持上述路径
                .paths(PathSelectors.any())
                .build();
    }
        //APi信息
    private ApiInfo apiInfo() {
return new ApiInfoBuilder()
        //标题
        .title("Swagger测试")
        //版本
        .version("1.0")
        //描述
        .description("第一个Swagger测试项目")
        //联系人相关
        .contact(new Contact("YZA","https://github.com/yzalzz","2559265773@qq.com"))
        //许可证
        .license("Apache License, Version 2.0")
        //服务条款
        .termsOfServiceUrl("https://swagger.io")
        .build();
    }
}

