package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.recruitmentService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("volunteer")
@RestController
@CrossOrigin("*")
public class recruitmentController {
    @Autowired
    private recruitmentService recruitmentService;
    @GetMapping("getlist")
    public ResultVo list(  @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,Long id){
        return recruitmentService.list(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.add(volunteerRecruitment);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.update(volunteerRecruitment);
    }
    @GetMapping("delete")
    public  ResultVo del(Long id){
        return recruitmentService.del(id);
    }
    @PostMapping("click")
    public ResultVo click(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.click(volunteerRecruitment.getId(),volunteerRecruitment.getLastClickTime());
    }

}
