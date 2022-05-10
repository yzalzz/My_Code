package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.recruitmentService;
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
public class recruitmentServiceImpl implements recruitmentService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;

    @Override
    public ResultVo list(Integer pageNum, Integer pageSize,Long id) {
        List<VolunteerRecruitment> volunteerRecruitments;

        ResultVo resultVO;

        try {
            if (id == null) {
                volunteerRecruitments = volunteerRecruitmentMapper.selectByExampleWithBLOBs(null);
                PageHelper.startPage(pageNum, pageSize);
            } else {
                VolunteerRecruitment volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(id);
               volunteerRecruitments = new ArrayList<>();
               volunteerRecruitments.add(volunteerRecruitment);
               if (volunteerRecruitment.getId()==null){

               }else {
                   click(volunteerRecruitment.getId(),null);
               }

            }

            PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(volunteerRecruitments);


            DataVo<VolunteerRecruitment> dataVO = new DataVo<>(pageInfo.getTotal(), volunteerRecruitments, pageNum, pageSize);

            resultVO = new ResultVo(200, "查询成功", true, dataVO);
        } catch (Exception e) {
            resultVO = new ResultVo(400, "查询失败", false, null);
        }

        return resultVO;
    }


    @Override
    public ResultVo add(VolunteerRecruitment volunteerRecruitment) {
        if (volunteerRecruitment.getCreateTime()==null){
            volunteerRecruitment.setCreateTime(new Date());
        }
        int affect = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"添加成功",true,volunteerRecruitment);
        }else {
            resultVo=new ResultVo(400,"添加失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(VolunteerRecruitment volunteerRecruitment) {
        int affect = volunteerRecruitmentMapper.updateByPrimaryKey(volunteerRecruitment);
        ResultVo resultVo;
        if (affect>0){
            VolunteerRecruitment result = volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId());
            resultVo=new ResultVo(200,"用户修改成功",true,result);
        }else {
            resultVo=new ResultVo(400,"用户修改失败",false,null);
        }
       return resultVo;
    }

    @Override
    public ResultVo del(Long id) {
        ResultVo resultVo;
        int affect = volunteerRecruitmentMapper.deleteByPrimaryKey(id);
        if (affect>0){
            resultVo=new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo=new ResultVo(400,"删除失败",false,null);
        }
        return resultVo;
    }


    @Override
    public ResultVo click(Long id, Date lastClickTime) {
       ResultVo resultVo;
       if (lastClickTime==null){
           lastClickTime=new Date();
       }
        int affect = volunteerRecruitmentMapper.click(id, lastClickTime);
        if (affect>0){
            resultVo=new ResultVo(200,"设置成功",true,null);
        }else {
            resultVo=new ResultVo(400,"设置失败",false,null);
        }
        return resultVo;
    }

}

