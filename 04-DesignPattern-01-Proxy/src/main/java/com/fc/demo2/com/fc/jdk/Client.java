package com.fc.demo2.com.fc.jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
   @Test
    public void test(){
       GamePlay gamePlayer = new GamePlayer();

       GamePlayOffice gamePlayOffice = new GamePlayOffice(gamePlayer);

       GamePlay proxy= (GamePlay) Proxy.newProxyInstance(
               gamePlayer.getClass().getClassLoader(),
               gamePlayer.getClass().getInterfaces(),
               gamePlayOffice);
proxy.login();
proxy.killBoss();
proxy.upgrade();

   }
}
