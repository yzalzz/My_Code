package com.fc.service;

import com.fc.Vo.NoteVO;
import com.fc.Vo.ResultVO;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;

import java.util.List;

public interface NoteService {



//    List<TbNote> note(Integer id, Integer noteId);




   NoteVO detail(Integer id);


    TbNote addOrUpdate(Integer id);


    ResultVO add(TbNote tbNote);

    ResultVO update(TbNote tbNote);

    NoteVO view(Integer id);

    ResultVO delete(Integer id);
}
