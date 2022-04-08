package com.fc.demo2.com.fc._static;

public class GamePlayerProxy implements GamePlay{
//
    private final GamePlay GamePlayer;

    public GamePlayerProxy(GamePlay gamePlayer) {
        GamePlayer = gamePlayer;
    }

    @Override
    public void login() {
        GamePlayer.login();
    }

    @Override
    public void killBoss() {
    GamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        GamePlayer.upgrade();
        this.luckDraw();
    }
    private void luckDraw(){
        System.out.println("抽到了一辆黄金玛莎");
    }
}
