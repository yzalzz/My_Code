package com.fc.service.impl;

import com.fc.dao.AlleviationMapper;
import com.fc.entity.Alleviation;
import com.fc.entity.AlleviationExample;
import com.fc.service.PolicyService;
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
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private AlleviationMapper alleviationMapper;

    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        if (lastClickTime==null){
            lastClickTime=new Date();
        }
        int affect = alleviationMapper.click(id, lastClickTime);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"设置成功",true,"");
        }else {
            resultVo=new ResultVo(400,"设置失败",false,"");
        }
        return resultVo;
    }

    @Override
    public ResultVo list(Integer pageNum, Integer pageSize,Long id) {
      List<Alleviation> alleviations;
      ResultVo resultVo;
      try {
          if (id == null) {
              PageHelper.startPage(pageNum, pageSize);
              alleviations=alleviationMapper.selectByExampleWithBLOBs(null);
          } else {
              Alleviation alleviation = alleviationMapper.selectByPrimaryKey(id);
              alleviations = new ArrayList<>();
              alleviations.add(alleviation);
              click(alleviation.getId(),null);
          }

          PageInfo<Alleviation> pageInfo = new PageInfo<>(alleviations);
          DataVo<Alleviation> dataVo = new DataVo<>(pageInfo.getTotal(),alleviations,pageNum,pageSize);

          resultVo= new ResultVo(200, "获取成功", true, dataVo);
      }catch (Exception e){
          resultVo= new ResultVo(400, "获取失败", false, null);
      }
      return resultVo;
    }

    @Override
    public ResultVo add(Alleviation alleviation) {
        ResultVo resultVo;
      if (alleviation.getCreateTime()==null){
          alleviation.setCreateTime(new Date());
      }
        int affect = alleviationMapper.insertSelective(alleviation);
        if (affect>0){
            resultVo=new ResultVo(200,"添加成功",true,alleviation);
        }else {
            resultVo=new ResultVo(400,"添加失败",false,null);
        }
      return resultVo;
    }
    @Override
    public ResultVo update(Alleviation alleviation) {
        ResultVo resultVo;
        int affect = alleviationMapper.updateByPrimaryKeySelective(alleviation);
        if (affect>0){

            resultVo=new ResultVo(200,"修改成功",true,alleviation);
        }else {
            resultVo=new ResultVo(400,"修改失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo del(Long id) {
        int affect = alleviationMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo=new ResultVo(400,"删除失败",false,null);
        }
        return resultVo;

    }
}
