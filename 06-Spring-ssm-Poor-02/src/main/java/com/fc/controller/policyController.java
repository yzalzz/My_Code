package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.PolicyService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("alleviation")
@RestController
@CrossOrigin("*")
public class policyController {
    @Autowired
    private PolicyService policyService;
    @PostMapping("click")
    public ResultVo click(@RequestBody Alleviation alleviation){
        return policyService.click(alleviation.getId(),alleviation.getLastClickTime());
    }
    @GetMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize, Long id){
        return policyService.list(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody Alleviation alleviation){
        return policyService.add(alleviation);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody Alleviation alleviation){
        return policyService.update(alleviation);
    }
    @GetMapping("delete")
    public ResultVo del(Long id){
        return policyService.del(id);

    }
}
