package com.fc.service;

import com.fc.Vo.ResultVO;
import com.fc.entity.TbNoteType;

import java.util.List;

public interface TypeService {


    List<TbNoteType> list( Integer userId);



    ResultVO delete(Integer id);

    List<TbNoteType> getTypes(Integer userId);




    ResultVO update(TbNoteType tbNoteType);

    ResultVO add(String typeName, Integer userId);
}
