package com.fc.controller;

import com.fc.Service.NoteTypeService;
import com.fc.entity.TbNoteType;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("type")
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;
    @GetMapping("list")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize, Integer id){
        return noteTypeService.list(pageNum,pageSize,id);
    }
    @PostMapping("addOrUpdate")
    public ResultVo addOrUpdate(@RequestBody TbNoteType tbNoteType){
        return noteTypeService.addOrUpdate(tbNoteType);
    }
    @GetMapping("delete")
    public ResultVo delete(@RequestBody Integer id){
        return noteTypeService.delete(id);
    }

}
