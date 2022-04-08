package com.fc.demo2.com.fc.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayOffice implements InvocationHandler {
    //真实对象（被代理对象）
    private final Object gamePlayer;

    public GamePlayOffice(Object gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    /*
    proxy  代理对象
    method 被代理类的方法
    args  被代理类的方法参数
    返回值  被代理类方法返回值
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("游戏代打进展："+method.getName());
        Object invoke = method.invoke(gamePlayer, args);
        return invoke;
    }
}
