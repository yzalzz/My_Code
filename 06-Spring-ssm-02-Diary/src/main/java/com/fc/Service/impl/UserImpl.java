package com.fc.Service.impl;

import com.fc.Service.UserService;
import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;

//    @Override
//    public ResultVo login(String username, String password) {
//        ResultVo resultVo=null;
//        //查一条数据
//        TbUser byName = tbUserMapper.findByName(username);
//        System.out.println(byName);
//        if (byName==null){
//            resultVo=new ResultVo(400,"用户名不存在",false,null);
//        }else {
//            if (username.equals(byName.getUsername())&&password.equals(byName.getPassword())){
//
//                resultVo=new ResultVo(200,"登录成功",true,username);
//            }else {
//                resultVo=new ResultVo(400,"用户名或密码错误",false,null);
//            }
//        }
//        return resultVo;
//    }

    @Override
    public ModelAndView login( HttpServletRequest req,HttpServletResponse resp,String username, String password) {
        ModelAndView mv = new ModelAndView();
        ResultVo resultVo;
        TbUser byName = tbUserMapper.findByName(username);
            if (byName == null) {
                resultVo = new ResultVo(400, "用户名不存在", false, null);
            } else {
                if (username.equals(byName.getUsername()) && password.equals(byName.getPassword())) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("username", username);
                    Cookie cookie = new Cookie("JSESSIONID", session.getId());
                    cookie.setMaxAge(30);
                    resp.addCookie(cookie);
                    mv.setViewName("/index.jsp");
                    resultVo = new ResultVo(200, "登录成功", true, username);
                } else {
                    resultVo = new ResultVo(400, "用户名或密码错误", false, null);
                }
            }
            return mv;
        }

    @Override
    public Map<String,Object>checkNick(String username) {
        Map<String, Object> map = new HashMap<>();
        TbUser byName = tbUserMapper.findByName(username);
        System.out.println(username);
        System.out.println(byName.getUsername());
        if (username.equals(byName.getUsername())){
            map.put("查到了",0);
            return map;
        }else {
            map.put("没查到",1);
        }
        return map;
    }
}
