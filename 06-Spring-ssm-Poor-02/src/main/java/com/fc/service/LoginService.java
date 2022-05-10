package com.fc.service;

import com.fc.vo.ResultVo;

public interface LoginService {
    ResultVo checkUser(String username, String password);

}
