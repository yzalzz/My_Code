package com.fc.Service.impl;

import com.fc.Service.NoteService;
import com.fc.dao.TbNoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteImpl implements NoteService {
    @Autowired
    private  TbNoteMapper noteMapper;
}
