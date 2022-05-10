package com.fc.service;

import com.fc.Vo.ResultVO;
import com.fc.entity.TbUser;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UserService {
    ResultVO login(String username, String password);

     Integer checkNick(String nick);

    ResultVO update(MultipartFile img, TbUser user);

}
