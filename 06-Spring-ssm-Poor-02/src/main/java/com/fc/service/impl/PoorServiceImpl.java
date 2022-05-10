package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
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
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;

    @Override
    public ResultVo list(Integer pageNum, Integer pageSize, Long id) {
        List<PoorWithBLOBs>poors;
        ResultVo resultVo;
        try {
            if (id == null) {
                poors = poorMapper.selectByExampleWithBLOBs(null);
                PageHelper.startPage(pageNum, pageSize);
            } else {
                PoorWithBLOBs poor = poorMapper.selectByPrimaryKey(id);
                poors = new ArrayList<>();
                poors.add(poor);
                if (poor.getId() == null) {

                } else {
                    click(poor.getId(), null);
                }
            }
            PageInfo<Poor> pageInfo = new PageInfo<>();
            DataVo<PoorWithBLOBs> dataVo = new DataVo<>(pageInfo.getTotal(), poors, pageNum, pageSize);
            resultVo = new ResultVo(200, "查询成功", true, dataVo);
        }catch (Exception e){
            resultVo= new ResultVo(400, "查询失败", false, null);
        }
        return resultVo;
    }

    @Override
    public ResultVo add(PoorWithBLOBs poor) {
        ResultVo resultVo;
        if (poor.getCreateTime()==null){
            poor.setCreateTime(new Date());
        }
        int affect = poorMapper.insertSelective(poor);
        if (affect>0){
            resultVo=new ResultVo(200,"添加成功",true,poor);
        }else {
            resultVo=new ResultVo(400,"添加失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(PoorWithBLOBs poor) {
        int affect = poorMapper.updateByPrimaryKey(poor);
        ResultVo resultVo;
        if (affect>0){
           Poor result = poorMapper.selectByPrimaryKey(poor.getId());
            resultVo=new ResultVo(200,"用户修改成功",true,result);
        }else {
            resultVo=new ResultVo(400,"用户修改失败",false,null);
        }
        return resultVo;

    }

    @Override
    public ResultVo del(Long id) {
        int affect = poorMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo=new ResultVo(400,"删除失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        if (lastClickTime==null){
            lastClickTime=new Date();
        }
        int affect = poorMapper.click(id, lastClickTime);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"设置成功",true,"");
        }else {
            resultVo=new ResultVo(400,"设置失败",false,"");
        }
        return resultVo;
    }
}



