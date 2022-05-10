package com.fc.controller;

import com.fc.Vo.ResultVO;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("list")
    public ModelAndView list( ModelAndView mv, HttpSession session){
        //获取域对象
        TbUser user= (TbUser) session.getAttribute("user");
        //获取域对象的id
        Integer userId = user.getId();

        List<TbNoteType>type = typeService.list(userId);

        mv.addObject("list",type);

        mv.addObject("menu_page","type");


        mv.addObject("changePage", "type/list.jsp");

        mv.setViewName("forward:/index.jsp");

        return mv;

    }
    @RequestMapping("addOrUpdate")
    @ResponseBody
    public ResultVO addOrUpdate(TbNoteType tbNoteType,HttpSession session){
        ResultVO resultVO;
       TbUser user = (TbUser) session.getAttribute("user");
        if (tbNoteType.getId() == null){
            resultVO=typeService.add(tbNoteType.getTypeName(),user.getId());
        }else {
            resultVO=typeService.update(tbNoteType);
        }


        return resultVO;
    }
    @GetMapping("delete")
    @ResponseBody
    public ResultVO delete(Integer id){
        return typeService.delete(id);
    }
}
