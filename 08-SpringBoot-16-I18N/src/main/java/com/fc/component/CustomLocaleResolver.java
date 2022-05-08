package com.fc.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//自定义的国际化解析器   实现一个接口LocaleResolver
@Component
public class CustomLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale locale = null;
        //获取请求参数
        String lang = request.getParameter("lang");
        //如果传递了指定的语言环境
        if (lang!=null&&!lang.equals("")){
            //split分割字符串
            String[] split = lang.split("_");

            locale=new Locale(split[0],split[1]);
        }else {
            //如果没有指定语言环境就默认中文
               locale= locale=Locale.CHINA;
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
