package com.fc.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter("/") //以前的方法
//@Component  //SpringBoot方法
//@Order(1)
public class RichFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("很有钱");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("更有钱");
    }
}
