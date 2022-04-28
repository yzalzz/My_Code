package com.fc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//自定义异常处理器
@RestControllerAdvice
public class CusetomExceptionHandler {
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(SingletDogException.class)
    public Map<String,Object> handleCustom(SingletDogException e){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-4000);
        map.put("message","发生单身狗异常");
        map.put("success",false);
        map.put("data",e.getMessage());
        return map;
    }
    //指定响应的状态码
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ExceptionHandler(Exception.class)
    public Map<String,Object> handleSystem(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-4000);
        map.put("message","发生系统异常");
        map.put("success",false);
        map.put("data",e.getMessage());
        return map;
    }

}
