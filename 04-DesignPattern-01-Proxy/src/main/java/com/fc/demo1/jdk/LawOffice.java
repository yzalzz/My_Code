package com.fc.demo1.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//动态代理分为jdk代理 基于接口代理 和 Aop代理 基于子类代理
//必须要实现InvocationHandler接口才能实现动态代理
//律师事务所 能生成律师
public class LawOffice implements InvocationHandler {
    //声明一个真实的被代理的对象
    private final Object parties;

    public LawOffice(Object parties) {
        this.parties = parties;
    }

    @Override

    /*
       参数：
       proxy : 代理对象
       method: 被代理类要执行的方法
       args:被代理类要执行方法的参数
       返回值：被代理类要执行的方法返回值

     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("案情进展"+method.getName());
        return method.invoke(parties,args);
    }
}
