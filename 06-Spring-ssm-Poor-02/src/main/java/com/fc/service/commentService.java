package com.fc.service;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.vo.ResultVo;

public interface commentService {
    ResultVo list(Integer pageNum, Integer pageSize,Long id);

    ResultVo add(MessageBoardWithBLOBs messageBoard);

    ResultVo del(Long id);

    ResultVo reply(Long id,String reply ,String replyPicture);

    ResultVo update(MessageBoardWithBLOBs messageBoardWithBLOBs);

}
