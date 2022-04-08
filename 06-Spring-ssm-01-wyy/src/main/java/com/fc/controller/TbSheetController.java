package com.fc.controller;

import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sheet")
public class TbSheetController {
    //控制层调用业务层
    @Autowired
    private TbSheetService tbSheetService;
    @RequestMapping("findAll")
    public List<TbSheet> findAll(){
        return tbSheetService.findAll();
    }
    @RequestMapping("insertSheet")
    public Map<Object, Object> insertSheet(TbSheet sheetName){
        Map<Object, Object> map = new HashMap<>();

        int affectRows= tbSheetService.insertSheet(sheetName);

        if (affectRows==1){
            map.put("code",200);
            map.put("message","添加成功");
        }else {
            map.put("message","创建失败");
            map.put("code",-200);
        }
        return map;
    }
    @RequestMapping("findSongsBySheet")
    public List<TbMusic>findSongsBySheet(String sheetName){
        return tbSheetService.findSongsBySheet(sheetName);
    }


}
