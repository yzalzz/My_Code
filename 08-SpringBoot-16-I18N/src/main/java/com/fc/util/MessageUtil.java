package com.fc.util;

import org.springframework.context.MessageSource;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
//国际化步骤
//声明messages 文件（字典）
// yml配置文件
// 写工具类


//国际化的工具类
@Component //将当前类注入到容器
public class MessageUtil {
    //声明一个MessageSource对象
    private static MessageSource messageSource;

    public MessageUtil(MessageSource messageSource) {
        MessageUtil.messageSource=messageSource;
    }
    //根据名称获取对应的翻译值
    public static String get(String msgKey){
        try{
            return   messageSource.getMessage(msgKey,null, LocaleContextHolder.getLocale());
        }catch (Exception e){
            return msgKey;
        }

    }
}
