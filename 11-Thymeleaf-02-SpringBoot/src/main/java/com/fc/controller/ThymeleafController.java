package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//因为我们使用的是模板引擎所以不能使用@RestController注解，不能跳过视图解析器
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
    @RequestMapping("testModel")
    public String test(Model model){
        //设置model
        model.addAttribute("data","hello");

        //直接会跳转到templates 下的index.html中
        //resources 存放资源
        //static 存放静态资源
        //templates 存放动态资源:模板引擎（这个路径下是不能直接通过url路径访问的，必须通过控制器去访问）
        //只需要下文件名
        return "index";
    }
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(ModelAndView mv) {
        mv.addObject("data","hellp");
        mv.setViewName("index");
        return mv;
    }
    @RequestMapping("test2")
    public String testModelAndView(HttpServletRequest request) {
       request.setAttribute("data","fffffff");

       //request.getRequestDispatcher("index").forward(request,response); 不能使用这种方式进行转发 不能被视图解析器计息
       return  "index";
    }

    }
