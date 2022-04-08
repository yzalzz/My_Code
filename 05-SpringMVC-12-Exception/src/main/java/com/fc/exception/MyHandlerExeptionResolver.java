package com.fc.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component //放在Spring容器中

//实现一个接口重写方法
public class MyHandlerExeptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        //如果是自定义异常
        if (ex instanceof  MyException){
            modelAndView.addObject("message","自定义异长");
        }
        else {
            modelAndView.addObject("message",ex.getMessage());
        }
        //跳转页面
        modelAndView.setViewName("/error.jsp");

        return modelAndView;
    }
}
