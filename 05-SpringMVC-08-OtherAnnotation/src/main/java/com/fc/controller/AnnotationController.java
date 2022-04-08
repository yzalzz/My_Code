package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("annotation")
public class AnnotationController {
    @RequestMapping("testRequestParam")
    public String testRequestParam(String id){
        System.out.println("从前端获取的数据"+id);
        return "/success.jsp";
    }
}
