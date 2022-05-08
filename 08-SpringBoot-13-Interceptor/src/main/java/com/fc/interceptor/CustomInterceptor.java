package com.fc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义拦截器要实现一个接口HandlerInterceptor 重写里面的默认方法
//拦截器一定要配置  spring要根据配置文件配置 springBoot要通过配置类配置
public class CustomInterceptor implements HandlerInterceptor {
    @Override
    //控制器执行之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle被执行");

        return true; //返回值是false拦截，是true就放行
    }

    @Override
    //控制器执行之后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle被执行");
    }

    @Override
    //页面渲染完成之后执行此方法 ，常用于资源释放
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion被执行");
    }
}
