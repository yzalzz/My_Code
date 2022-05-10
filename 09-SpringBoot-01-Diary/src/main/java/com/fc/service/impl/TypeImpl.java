package com.fc.service.impl;

import com.fc.Vo.ResultVO;
import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TypeImpl implements TypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;


    @Override
    public List<TbNoteType> list( Integer userId) {
        List<TbNoteType> list = tbNoteTypeMapper.findIdAndUserId( userId);

        return list;
    }
    

    @Override
    public ResultVO delete( Integer id) {
        ResultVO resultVO;
        int i = tbNoteTypeMapper.deleteByPrimaryKey(id);
        if (i>0){
            resultVO=new ResultVO(1,"success",true,"");
        }else {
            resultVO=new ResultVO(0,"fail",false,"");
        }
        return resultVO;
    }

    @Override
    public List<TbNoteType> getTypes(Integer userId) {
        TbNoteTypeExample tbNoteTypeExample = new TbNoteTypeExample();
        TbNoteTypeExample.Criteria criteria = tbNoteTypeExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<TbNoteType> list = tbNoteTypeMapper.selectByExample(tbNoteTypeExample);
        return list;
    }

    //添加虽然不需要日记id 但是需要用户id
    @Override
    public ResultVO add(String typeName, Integer userId) {
        ResultVO resultVO;
        TbNoteType tbNoteType = new TbNoteType();
        tbNoteType.setTypeName(typeName);
        tbNoteType.setUserId(userId);

        int i = tbNoteTypeMapper.insertSelective(tbNoteType);
        if (i>0){
            resultVO=new ResultVO(1,"添加或修改成功",true,tbNoteType.getId());
        }else {
            resultVO=new ResultVO(0,"添加或修改失败",false,"");
        }
        return resultVO;
    }

    @Override
    public ResultVO update(TbNoteType tbNoteType) {
        ResultVO resultVO;
        int i = tbNoteTypeMapper.updateByPrimaryKeySelective(tbNoteType);
        if (i>0){
            resultVO=new ResultVO(1,"添加或修改成功",true,tbNoteType);
        }else {
            resultVO=new ResultVO(0,"添加或修改失败",false,"");
        }
        return resultVO;
    }
}
