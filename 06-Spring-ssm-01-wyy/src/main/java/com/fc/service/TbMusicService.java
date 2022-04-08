package com.fc.service;

import com.fc.entity.TbMusic;
import com.fc.entity.TbMusicExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TbMusicService {

    //查询全部
    List<TbMusic> findAll();
    //根据Id查询
    TbMusic findById(Integer musicId);

    TbMusic nextSong(Integer musicId);

    TbMusic prevSong(Integer musicId);


    List<TbMusic> search(String keyword);
}
