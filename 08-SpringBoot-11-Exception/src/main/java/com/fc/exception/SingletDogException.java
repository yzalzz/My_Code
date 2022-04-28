package com.fc.exception;
//自定义异常类 必须继承一个接口Exception
public class SingletDogException extends Exception {
    public SingletDogException() {
        super();
    }

    public SingletDogException(String message) {
        super(message);
    }
}
