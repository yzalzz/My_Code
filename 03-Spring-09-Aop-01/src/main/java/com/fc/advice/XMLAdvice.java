package com.fc.advice;

import org.aspectj.lang.ProceedingJoinPoint;

//Advice 增强类
//切面类 用于指定增强的方法
public class XMLAdvice {
    //前置通知
public void before(){
    System.out.println("前置通知，在方法执行前执行~~~  蹲坑秘籍孟家独传");
}
public  void  AfterReturning(){
    System.out.println("后置通知，方法运行后调用~~~~~");
}
public void After(){
    System.out.println("最终通知");
}

    // 环绕通知
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知--前置");

        // 执行被代理对象的方法
        Object proceed = joinPoint.proceed();

        System.out.println("环绕通知--后置");

        return proceed;
    }
}
