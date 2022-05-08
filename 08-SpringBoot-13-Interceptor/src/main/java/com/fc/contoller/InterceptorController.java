package com.fc.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller//@RestController跳过视图解析器 不能跳转html,jsp页面
//@Controller 能跳转html,jsp页面
@RequestMapping("interceptor")
public class InterceptorController {
    @RequestMapping("test")
    public String test(){
        return "redirect:/index.html";
    }
}
