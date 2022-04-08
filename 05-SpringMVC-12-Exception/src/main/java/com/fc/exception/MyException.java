package com.fc.exception;
//自定义异常要继承Exception
public class MyException extends  Exception{
    public MyException(){
        super();
    }
    public MyException(String message){
        super(message);
    }
}
