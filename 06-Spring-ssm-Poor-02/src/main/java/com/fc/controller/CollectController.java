package com.fc.controller;


import com.fc.service.CollectService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fc.entity.Collection;

@RestController
@RequestMapping("collection")
@CrossOrigin("*")
public class CollectController {
    //
    @Autowired
    private CollectService collectService;
    @GetMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize, Long id){
       return collectService.list(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody Collection collection){
        return collectService.add(collection);
    }
    @GetMapping("delete")
    public ResultVo del(Collection id){
       return collectService.del((com.fc.entity.Collection) id);
    }
}

