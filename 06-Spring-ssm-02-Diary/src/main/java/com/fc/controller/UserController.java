package com.fc.controller;

import com.fc.Service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
//    @PostMapping("login")
//    public ResultVo login(@RequestBody String username,@RequestBody String password){
//        return userService.login(username,password);
//    }
    @PostMapping("login")
    public ModelAndView login(HttpServletRequest req, HttpServletResponse resp, @RequestParam String username, @RequestParam String password){
        return userService.login(req,resp,username,password);
    }
    @GetMapping("checkNick")
    public Map<String ,Object> checkNick(@RequestBody String username){
        return userService.checkNick(username);
    }

}
