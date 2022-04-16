package com.fc.controller;

import com.fc.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @PostMapping("view")
    public ModelAndView view(){

    }
}
