package com.fc.demo1.jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Court {
    @Test
    public void test() {
        Lawsuit parties = new Parties();
        LawOffice lawOffice = new LawOffice(parties);
        // 获取代理对象
        /*
        Proxy类  返回指定接口的代理类对象
        loader  被代理类的类加载器
        Interfaces 被代理类所实现的所有接口
        h 将方法调用分派给指定的处理器
        返回值  代理对象
         */
        Lawsuit proxy = (Lawsuit) Proxy.newProxyInstance(parties.getClass().getClassLoader(),
                parties.getClass().getInterfaces(),
                lawOffice);
                proxy.depend();
                 proxy.submit();

    }
}
