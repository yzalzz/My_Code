package com.fc.Service.impl;

import com.alibaba.fastjson.JSON;
import com.fc.Service.NoteTypeService;
import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteTypeImpl implements NoteTypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;

    @Override
    public ResultVo list(Integer pageNum, Integer pageSize, Integer id) {
        List<TbNoteType> list = tbNoteTypeMapper.findAll(id);

        ResultVo resultVo = null;
        if (id == null) {
            resultVo = new ResultVo(400, "查询失败", false, null);

        } else {
            resultVo = new ResultVo(200, "查询成功", true, list);
        }

        return resultVo;
    }

    @Override
    public ResultVo addOrUpdate(TbNoteType tbNoteType) {
        ResultVo resultVo = null;
        if (tbNoteType.getId() != null) {
            int affect = tbNoteTypeMapper.updateByPrimaryKeySelective(tbNoteType);
            if (affect > 0) {
                //把修改过的tbNoteType拿过来
                TbNoteType result = tbNoteTypeMapper.selectByPrimaryKey(tbNoteType.getId());
                resultVo = new ResultVo(200, "修改成功", true, result);
            } else {
                resultVo = new ResultVo(400, "修改失败", false, null);
            }
        } else {
            int affect = tbNoteTypeMapper.insertSelective(tbNoteType);
            if (affect > 0) {
                resultVo = new ResultVo(200, "增加成功", true, tbNoteType);
            } else {
                resultVo = new ResultVo(400, "增加失败", false, null);
            }
        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Integer id) {
        ResultVo resultVo;
        if (id==null){
            resultVo=new ResultVo(400,"删除失败",false,"");
        }
        int i = tbNoteTypeMapper.deleteByPrimaryKey(id);
        if (i>0){
            resultVo=new ResultVo(200,"删除成功",true,"");
        } else {
            resultVo=new ResultVo(400,"删除失败",false,"");
        }

        return resultVo;
    }
}
