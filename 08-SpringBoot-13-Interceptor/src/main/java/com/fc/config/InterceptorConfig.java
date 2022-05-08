package com.fc.config;

import com.fc.interceptor.CustomInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //声明此注解说明这个类是配置类

// 因为此类要实现 web组件的内容 所以要实现 WebMvcConfigurer
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //将拦截器注入到容器中
        registry.addInterceptor(new CustomInterceptor())
                //拦截器优先级
                .order(-1)
                //拦截路径
                .addPathPatterns("/**")
                //不走拦截器的路径
                .excludePathPatterns("/index.html");
    }
}