package com.fc.config;

import com.fc.compent.CustomLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
//
//@Configuration
public class LocaleConfig implements WebMvcConfigurer {
//    @Bean
//    public LocaleResolver localeResolver() {
//        return new CustomLocaleResolver();
//    }
@Bean
public LocaleResolver localeResolver(){
    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
    //设置默认中文国际化
    localeResolver.setDefaultLocale(Locale.CHINA);
    return localeResolver;
}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

            LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
            localeChangeInterceptor.setParamName("lang");
            registry.addInterceptor(localeChangeInterceptor);
        }


}
