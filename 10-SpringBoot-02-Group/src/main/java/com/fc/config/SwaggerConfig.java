package com.fc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

//@EnableSwagger2开启自动装配Swagger, 2.10.5没有这个注解
@EnableSwagger2WebMvc //2.10.5 用这个注解
//@EnableKnife4j//开启Knife4j 默认就是开启的
//swagger配置类
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                //添加API信息
                .apiInfo(apiInfo())
                //全局的操作参数
                .globalOperationParameters(token())
                //允许查看所有的API
                .select()
                //指定生成文档的路径
                .apis(RequestHandlerSelectors.basePackage("com.fc"))
                //支持上述路径
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //标题
                .title("Swagger测试")
                //版本
                .version("1.0")
                //描述
                .description("爱你比永远多一天")
                //服务条款
                .termsOfServiceUrl("https://swagger.io")
                //许可证
                .license("Apache License, Version 2.0")
                //联系人
                .contact(new Contact("YZA","https://github.com/yzalzz","2559265773@qq.com"))
                .build();
    }
    //设置全局变量
    private List<Parameter> token(){
        //参数建造起
        ParameterBuilder parameterBuilder = new ParameterBuilder();

        ArrayList<Parameter> parameters= new ArrayList<>();

        // 参数名
        parameterBuilder.name("Authorization")
                //设置参数的数据类型
                .description("JWT令牌")
                //设置参数的数据类型
                .modelRef(new ModelRef("string"))
               //设置参数类型
                .parameterType("header")
                //设置默认值
                .defaultValue("issue token")
                //示例
                .scalarExample("123456")
                //是否必须
                .required(false);
    //将构建出来的参数存入集合
        parameters.add(parameterBuilder.build());
        return parameters;



    }



//    //装配Swagger 的Bean对象
//    @Bean
//    public Docket docket() {
//        //创建对象使用Swagger作为文档类型
//        return new Docket(DocumentationType.SWAGGER_2)
//                //添加API信息
//                .apiInfo(apiInfo())
//                //允许查看所有的API信息
//                .select()
//                //指定文档生成的路径
//                .apis(RequestHandlerSelectors.basePackage("com.fc"))
//                //支持上述路径
//                .paths(PathSelectors.any())
//                .build();
//    }
//        //APi信息
//    private ApiInfo apiInfo() {
//return new ApiInfoBuilder()
//        //标题
//        .title("Swagger测试")
//        //版本
//        .version("1.0")
//        //描述
//        .description("第一个Swagger测试项目")
//        //联系人相关
//        .contact(new Contact("YZA","https://github.com/yzalzz","2559265773@qq.com"))
//        //许可证
//        .license("Apache License, Version 2.0")
//        //服务条款
//        .termsOfServiceUrl("https://swagger.io")
//        .build();
//    }
}

