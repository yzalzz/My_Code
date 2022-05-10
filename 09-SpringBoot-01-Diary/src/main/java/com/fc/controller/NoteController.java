package com.fc.controller;

import com.fc.Vo.NoteVO;
import com.fc.Vo.ResultVO;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.NoteService;
import com.fc.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private TypeService typeService;


    @GetMapping("view")
    public ModelAndView view(Integer id, HttpSession session,ModelAndView mv) {
      if (id!=null){
          NoteVO noteVO=noteService.view(id);
          mv.addObject("noteInfo",noteVO);
      }
        TbUser user = (TbUser) session.getAttribute("user");
        Integer userId = user.getId();
        List<TbNoteType> list=typeService.getTypes(userId);
        mv.addObject("typeList", list);
        mv.addObject("changePage", "note/view.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;

    }








    @GetMapping("detail")
    public ModelAndView detail(Integer id,ModelAndView mv){

       NoteVO vo = noteService.detail(id);

       mv.addObject("note",vo);
        mv.addObject("changePage","/note/detail.jsp");
//        mv.addObject("menu_page", "note");
        mv.setViewName("forward:/index.jsp");

        return mv;

    }
    @PostMapping ("addOrUpdate")
    public ModelAndView addOrUpdate(ModelAndView mv, TbNote tbNote,HttpSession session){
           //高亮
        mv.addObject("menu_page","note");
        ResultVO resultVO ;

        if (tbNote.getId() !=null){
            resultVO=noteService.update(tbNote);
        }else {
            resultVO=noteService.add(tbNote);
        }
        if (resultVO.getCode()==1){
            mv.setViewName("redirect:/index/page");
        }else {
            mv.addObject("resultInfo",resultVO);
            mv.addObject("id",tbNote.getId());
            mv.setViewName("forward:/note/view");
        }
        return mv;

    }
    @GetMapping("delete")
    @ResponseBody
    public ResultVO delete(Integer id){

        return  noteService.delete(id);
    }













//    @GetMapping("view")
//    public ModelAndView view(Integer id, HttpSession session,ModelAndView mv) {
//        TbUser user = (TbUser) session.getAttribute("user");
//        Integer userId = user.getId();
//
//        List<TbNoteType> list = noteService.list(id, userId);
//        if (list.size()>0){
//          mv.addObject("noteInfo",id);
//        }
//        mv.addObject("typeList", list);
//        mv.addObject("changePage", "note/view.jsp");
//        mv.setViewName("forward:/index.jsp");
//
//        return mv;
//    }
//    @GetMapping("detail")
//
//    public ModelAndView detail(ModelAndView mv,HttpSession session,  Integer id){
//
//        TbNote tbNote=noteService.detail(id);
//        session.setAttribute("note",tbNote);
//        mv.addObject("changePage","/note/detail.jsp");
//        mv.setViewName("forward:/index.jsp");
//        return mv;
//    }
//    @PostMapping ("addOrUpdate")
//    public ModelAndView addOrUpdate(ModelAndView mv, TbNote tbNote,HttpSession session){
//        TbNote note = noteService.detail(tbNote.getId());
//   if (tbNote.getId()==null){
//       int add=   noteService.add(tbNote);
//       if (add>0){
//           mv.setViewName("redirect:/index.jsp");
//       }
//   }else {
//       session.setAttribute("id",tbNote.getId());
//       int update= noteService.update(tbNote);
//       if (update>0){
//           mv.setViewName("redirect:/index.jsp");
//       }
//   }
////    session.setAttribute("resultInfo",note);
//
//    mv.setViewName("forward:/note/view");
//    return mv;
//    }
    }
