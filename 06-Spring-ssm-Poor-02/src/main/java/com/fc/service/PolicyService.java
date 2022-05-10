package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.vo.ResultVo;

import java.util.Date;

public interface PolicyService {
    ResultVo click(Long id,Date lastClickTime);

    ResultVo list(Integer pageNum, Integer pageSize,Long id);

    ResultVo add(Alleviation alleviation);

    ResultVo update(Alleviation alleviation);

    ResultVo del(Long id);

}
