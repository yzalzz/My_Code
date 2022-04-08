package com.fc.demo1._static;
//代理类  代理类里一定要有一个真实对象
public class Lawyer implements Lawsuit{
    //真实的对象(被代理对象)
    private final Lawsuit parties;

    public Lawyer(Lawsuit parties) {
        this.parties = parties;
    }

    @Override
    public void submit() {
        //代理控制这对原对象的访问
        this.CollectEvidence();
        parties.submit();
    }

    @Override
    public void defend() {

        parties.defend();
        this.compareNotes();
    }
    //代理能加强原
    private void CollectEvidence(){
        System.out.println("搜集孟蹲坑证据");
    }
    private void compareNotes(){
        System.out.println("两方交换意见 决定孟先蹲");
    }

}
