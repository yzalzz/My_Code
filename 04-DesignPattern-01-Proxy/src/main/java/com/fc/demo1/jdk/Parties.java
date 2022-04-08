package com.fc.demo1.jdk;

public class Parties implements Lawsuit{
    @Override
    public void submit() {
        System.out.println("田打吃鸡");
    }

    @Override
    public void depend() {
        System.out.println("祁某寒非得坑他");
    }
}
