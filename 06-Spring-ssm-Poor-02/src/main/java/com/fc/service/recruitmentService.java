package com.fc.service;

import com.fc.entity.VolunteerRecruitment;
import com.fc.vo.ResultVo;

import java.util.Date;

public interface recruitmentService {
    ResultVo list(Integer pageNum, Integer pageSize,Long id);

    ResultVo add(VolunteerRecruitment volunteerRecruitment);

    ResultVo update(VolunteerRecruitment volunteerRecruitment);

    ResultVo del(Long id);

    ResultVo click(Long id, Date lastClickTime);
}
