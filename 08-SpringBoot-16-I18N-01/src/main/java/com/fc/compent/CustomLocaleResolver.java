package com.fc.compent;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

// 自定义国际化解析器 实现LocaleResolver接口 ， 还可以通过配置类实现WebMvcConfigurer，通过拦截器实现国际化
//@Component("localeResolver") //localeResolver 名字要保持一致
public class CustomLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");

        Locale locale;

        // 如果传递了指定的语言环境
        if (lang != null && !lang.equals("")) {
            String[] array = lang.split("_");

            locale = new Locale(array[0], array[1]);
        } else {
            // 如果没有指定默认使用中文
            locale = Locale.CHINA;
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }
}