package com.fc.service.impl;

import com.fc.dao.TbSheetMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbSheetServiceImpl implements TbSheetService {
    //业务层调用dao层
    @Autowired
    private TbSheetMapper tbSheetMapper;
    @Override
    public List<TbSheet> findAll() {

        return tbSheetMapper.selectByExample(null);
    }

    @Override
    public Integer insertSheet(TbSheet sheetName) {
        return tbSheetMapper.insert(sheetName);
    }

    @Override
    public List<TbMusic> findSongsBySheet(String sheetName) {

        return tbSheetMapper.findSongsBySheet(sheetName);
    }


}
