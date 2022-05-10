package com.fc.service;

import com.fc.entity.Collection;
import com.fc.vo.ResultVo;

public interface CollectService {


    ResultVo list(Integer pageNum, Integer pageSize,Long id);

    ResultVo del(Collection id);

    ResultVo add(Collection collection);
}
