package com.fc.controller;

import com.fc.Vo.NoteVO;
import com.fc.entity.TbNote;
import com.fc.entity.TbUser;
import com.fc.service.IndexService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    private IndexService indexService;

    /**
     *
     * @param id typeId 日记类型id
     * @param title 日记的标题
     * @param date 日期
     */
    @RequestMapping(value = "page", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView page(Integer id,
                             String title,
                             String date,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "3") Integer pageSize,
                             HttpSession session,
                             ModelAndView mv) {
        // 获取域对象中的user
        TbUser user = (TbUser) session.getAttribute("user");

        // 获取用户id
        Integer userId = user.getId();

        PageInfo<TbNote> pageInfo = indexService.page(pageNum, pageSize, userId, id, title, date);


        //获取所有日记的日期分类
        List<NoteVO> dateInfo=indexService.findDateInfo(userId);
        mv.addObject("dateInfo", dateInfo);

        //获取所有的日记类别
        List<NoteVO> typeInfo=indexService.findTypeInfo(userId);
        mv.addObject("typeInfo", typeInfo);


        mv.addObject("page", pageInfo);

        mv.addObject("changePage", "/note/list.jsp");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }
    @GetMapping("searchType")
    public ModelAndView searchType(ModelAndView mv,Integer id,HttpSession session){
            session.setAttribute("id",id);
            mv.setViewName("forward:/index/page");
            return mv;
    }
    @GetMapping("searchTitle")
    public ModelAndView searchTitle(ModelAndView mv,HttpSession session,String title){
        session.setAttribute("title",title);
        mv.setViewName("forward:/index/page");
        return mv;
    }
    @GetMapping("searchDate")
    public ModelAndView searchDate(ModelAndView mv, HttpSession session, String date){
        session.setAttribute("pubTime",date);
        mv.setViewName("forward:/index/page");
        return mv;
    }
}