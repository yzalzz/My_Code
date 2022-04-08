package com.fc.demo2.com.fc._static;

import org.junit.Test;

public class Client {
    @Test
    public void test(){
        GamePlay gamePlayer = new GamePlayer();

        GamePlay gamePlayerProxy = new GamePlayerProxy(gamePlayer);

        gamePlayerProxy.login();
        gamePlayerProxy.killBoss();
        gamePlayerProxy.upgrade();
    }
}
