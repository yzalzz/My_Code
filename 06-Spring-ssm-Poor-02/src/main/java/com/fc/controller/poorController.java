package com.fc.controller;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("poor")
@CrossOrigin("*")
public class poorController {
    @Autowired
    private PoorService poorService;
    @GetMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize, Long id){
        return poorService.list(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody PoorWithBLOBs poor){
        return poorService.add(poor);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody PoorWithBLOBs poor){
        return poorService.update(poor);
    }
    @GetMapping("delete")
    public ResultVo del(Long id){
        return poorService.del(id);
    }
    @PostMapping("click")
    public ResultVo click(@RequestBody Poor poor){
        return poorService.click(poor.getId(),poor.getLastClickTime());
    }
}
