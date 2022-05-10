package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.commentService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("msgboard")
@RestController
@CrossOrigin("*")
public class commentController {
    @Autowired
    private commentService commentService;
    @GetMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize, Long id){
       return commentService.list(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody MessageBoardWithBLOBs messageBoard){
        return commentService.add(messageBoard);
    }
    @GetMapping("delete")
    public ResultVo del(Long id){
        return commentService.del(id);
    }
    @PostMapping("reply")
    public ResultVo reply(@RequestBody MessageBoardWithBLOBs messageBoard){
        return commentService.reply(messageBoard.getId(),messageBoard.getReply(),messageBoard.getReplyPicture());
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs){
        return commentService.update(messageBoardWithBLOBs);
    }
}
