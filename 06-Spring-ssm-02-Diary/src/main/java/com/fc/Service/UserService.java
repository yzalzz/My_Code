package com.fc.Service;

import com.fc.vo.ResultVo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UserService {
//    ResultVo login(String username, String password);

    ModelAndView login(HttpServletRequest req, HttpServletResponse resp,String username, String password);

    Map<String,Object> checkNick(String username);
}
