package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.commentService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class commentServiceImpl implements commentService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public ResultVo list(Integer pageNum, Integer pageSize,Long id) {
        List<MessageBoardWithBLOBs> messageBoardList;

        ResultVo resultVO;

        try {
            if (id == null) {
                PageHelper.startPage(pageNum, pageSize);
               messageBoardList = messageBoardMapper.selectByExampleWithBLOBs(null);
            } else {
                MessageBoardWithBLOBs messageBoardWithBLOBs = messageBoardMapper.selectByPrimaryKey(id);
               messageBoardList = new ArrayList<>();
                messageBoardList.add(messageBoardWithBLOBs);
            }

            PageInfo<MessageBoardWithBLOBs> pageInfo = new PageInfo<>(messageBoardList);

            DataVo<MessageBoardWithBLOBs> dataVO = new DataVo<>(pageInfo.getTotal(), messageBoardList, pageNum, pageSize);

            resultVO = new ResultVo(200, "查询成功", true, dataVO);
        } catch (Exception e) {
            resultVO = new ResultVo(400, "查询失败", false, null);
        }

        return resultVO;
    }


    @Override
    public ResultVo add(MessageBoardWithBLOBs messageBoard) {
        if (messageBoard.getCreateTime()==null){
            messageBoard.setCreateTime(new Date());
        }
        int affect = messageBoardMapper.insertSelective(messageBoard);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"添加成功",true,messageBoard);
        }else {
            resultVo=new ResultVo(400,"添加失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo del(Long id) {
        int affect = messageBoardMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo=new ResultVo(400,"删除失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo reply(Long id, String reply ,String replyPicture) {
        ResultVo resultVo;
        int update = messageBoardMapper.update(id, reply, replyPicture);
        if (update>0){
                resultVo=new ResultVo(200,"回复成功",true,"");
            }else {
                resultVo=new ResultVo(400,"回复失败",false,null);
            }
            return resultVo;
        }

    @Override
    public ResultVo update(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        ResultVo resultVo;
        int affect = messageBoardMapper.updateByPrimaryKeySelective(messageBoardWithBLOBs);
        if (affect>0){

            resultVo=new ResultVo(200,"修改成功",true,messageBoardWithBLOBs);
        }else {
            resultVo=new ResultVo(400,"修改失败",false,null);
        }
        return resultVo;
    }

}






