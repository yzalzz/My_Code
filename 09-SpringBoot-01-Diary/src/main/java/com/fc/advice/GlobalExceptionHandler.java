package com.fc.advice;

import com.fc.Vo.ResultVO;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice//增强Controller
//全局异常处理器
public class GlobalExceptionHandler {
    //对指定异常进行捕获
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody //后端给前端发送Json
//    @RequestBody 接受前端请求的Json数据
    public ResultVO handleDuplicateKeyException(DuplicateKeyException e){
        return new ResultVO(4000,"当前用户名已存在,不会用请找系统管理员",false,e.getMessage());
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResultVO handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return new ResultVO(4002,"请检查你的请求方式是否正确",false,e.getMessage());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultVO handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return new ResultVO(4001,"请输入json格式的参数",false,e.getMessage());
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultVO handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        return new ResultVO(4003,"缺少了必要的参数",false,e.getMessage());
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultVO handleRuntimeException(RuntimeException e){
        return new ResultVO(4004,"你的操作有误",false,e.getMessage());
    }


}
