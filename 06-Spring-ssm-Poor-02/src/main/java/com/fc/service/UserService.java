package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVo;

public interface UserService {




     ResultVo list(Integer pageNum, Integer pageSize, User param);


    ResultVo del(Long id);

    ResultVo updata(User user);

    ResultVo add(User user);


    ResultVo login(String username, String password);

}
