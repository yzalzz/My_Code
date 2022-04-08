package com.fc.service;

import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;

import java.util.List;

public interface TbSheetService {
    List<TbSheet> findAll();

    Integer insertSheet(TbSheet sheetName);


    List<TbMusic> findSongsBySheet(String sheetName);
}
