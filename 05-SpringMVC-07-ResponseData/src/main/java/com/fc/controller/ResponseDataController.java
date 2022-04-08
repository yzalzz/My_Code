package com.fc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("response")
public class ResponseDataController {
    @RequestMapping("void")
public void testVoid(){
    System.out.println("测试void");
}
@RequestMapping("String")
//响应方式 直接使用字符串跳到对应的jsp,html页面
    public String testString(){
    System.out.println("测试String");
    return "/success.jsp";
}


@RequestMapping("ModelAndView")
 public ModelAndView testModelAndView(){
        //创建一个ModelAndView(创建试图模型对象)对象
    ModelAndView mv = new ModelAndView("/success.jsp");
    //添加模型
    //调用方法 addObject里面是键值对
    mv.addObject("username","加油");
    //设计试图
    //调用方法   setViewName跳转页面
//    mv.setViewName("/success.jsp");
    return mv;
}
//ModelAndView对象可以直接通过方法形参列表从Spring容器中获取
@RequestMapping("ModelAndView2")
public ModelAndView ModelAndView2(ModelAndView mv){
        mv.addObject("username","胡歌");
        mv.setViewName("/success.jsp");
        return mv;

}
//不用ModelAndView 直接用Model和字符串
    @RequestMapping("Model")
    public String ModelAndView3(Model model){
      model.addAttribute("username","顾小涵涵");
      return "/success.jsp";

    }
    //重定向 用的是响应对象 url地址会发生改变
    @RequestMapping("testRedirect")
    public void testRedirect(HttpServletResponse response){
        try {
            response.sendRedirect("/success.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //转发  用的是请求对象  url地址不会发生改变
    //只要能携带参数全部都是转发
    @RequestMapping("testReForward")
    public void testReForward(HttpServletRequest request,HttpServletResponse response){
        try {
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //转发重定向太麻烦 复杂 可以通过返回值走视图解析器
@RequestMapping("testStringRedirect")
    public String testStringRedirect(){
        //在里面直接写重定向
        return "redirect:/success.jsp";
    }
    @RequestMapping("testStringForward")
    public String testStringForward(){
        //在里面直接写重定向
        return "forward:/success.jsp";
    }
    //@ResponseBody 可以返回json格式的数据  如果使用这个注解视图解析器就会失效 因为视图解析器只能解析ModelAndView
    @RequestMapping("testResponseBody")
    @ResponseBody
        public void testResponseBody(){
        System.out.println("测一测看会不会报错");
        }

        @RequestMapping(value = "testStringResponseBody",produces = "text/html; charset = UTF-8")
        @ResponseBody
        public String  testStringJson(){
        return "你好";
        }


    @RequestMapping(value = "testJsonString",produces = "text/html; charset = UTF-8")
    @ResponseBody
    public String  testJsonString(){
        //  "/"转义字符
        return"{\"username\"\":袁子昂\",\"password\":\"123456\"}";
    }
    //JAVA对象转为json对象
    // 3种方式 new ObjectMapper(),  直接返回user需要配置文件 , map
    @RequestMapping(value = "getStringJson",produces ="text/html; charset = UTF-8")
    @ResponseBody //此注解可以返回json格式的数据
    public String getStringJson(){
        User user = new User();
        user.setName("费羊羊");
        user.setAge(15);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("我爱美羊羊");
        //创建一个对象映射器
        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        try {
            //通过此方法将Java User对象转为json
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(json);

        return json;
    }
    //直接return user 但是需要配置文件
    @RequestMapping( value = "getStringJson2",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User getStringJson2(){
        User user = new User();
        user.setName("喜羊羊");
        user.setAge(15);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("我爱美羊羊");
        return user;
    }
    @RequestMapping( value = "getMap",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> getMap(){
        //创建map对象
        Map<String, Object> map = new HashMap<>();

        User user = new User();
        user.setName("喜羊羊");
        user.setAge(15);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("我爱美羊羊");
        //
        ArrayList<Object> foods = new ArrayList<>();
        foods.add("牛奶");
        foods.add("烧鸡");
        foods.add("牛肉");
        foods.add("香肠");
        //
        map.put("code",200);
        map.put("message","查询成功");
        map.put("data",user);
        map.put("foods",foods);

        return map;
    }
    //只用3种 ModelAndView(前后端不分离) ，Json ,Map

}
