package com.fc.controller;

import com.fc.exception.SingletDogException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//如果前后端不分离可以直接自定义错误页面
//如果前后端分离 就要给前端一个json
@RestController
@RequestMapping("exception")
public class ExceptionController {
    @RequestMapping("system")
    public void testSystemException(@RequestParam Integer id){
        int num=1/0;
    }
    @RequestMapping("singletion")
    public void testCustomException() throws SingletDogException {
        throw new SingletDogException("单身狗异常");
    }
}
