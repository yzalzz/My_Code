package com.fc.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.LogRecord;
//过滤器
//@WebFilter("/") //不适用此注解过滤器无效 ，以前的方法
//@Component //SpringBoot方法 ，但是无法指定过滤的对象 只能过滤全部
//@Order(-1)//指定注入到容器的顺序 数值越大优先级越低
public class SexFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤前只要女的");
        //
        chain.doFilter(request,response);
        System.out.println("过滤后温柔。");
    }
}
