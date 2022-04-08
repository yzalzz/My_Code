package com.fc.controller;

import com.fc.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exception")
public class UserController {
    //系统异常
    @RequestMapping("system")
    public String system(){
        int i =1/0;
     return "/index.jsp" ;
    }
    //自定义异常
    @RequestMapping("custom")
    public void custom() throws MyException {
        throw new MyException();

    }


}
