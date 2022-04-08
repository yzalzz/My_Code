package com.fc.demo1._static;
//原告类（被代理对象  真实对象  ）
public class Parties implements Lawsuit{
    @Override
    public void submit() {
        System.out.println("孟志斌霸占厕所");
    }

    @Override
    public void defend() {
        System.out.println("肖志龙想去厕所");
    }
}
