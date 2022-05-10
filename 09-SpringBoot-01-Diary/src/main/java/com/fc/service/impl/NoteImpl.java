package com.fc.service.impl;

import com.fc.Vo.NoteVO;
import com.fc.Vo.ResultVO;
import com.fc.dao.TbNoteMapper;
import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteImpl implements NoteService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;
    @Autowired
    private TbNoteMapper noteDao;


    @Override
    public NoteVO detail(Integer id) {

        return noteDao.detail(id);
    }

    @Override
    public TbNote addOrUpdate(Integer id) {
        return null;
    }

    @Override
    public ResultVO update(TbNote tbNote) {
        ResultVO resultVO = new ResultVO();

        if (tbNote.getPubTime() == null) {
            tbNote.setPubTime(new Date());
        }

        int affectedRows = noteDao.updateByPrimaryKeyWithBLOBs(tbNote);

        if (affectedRows > 0) {
            resultVO.setCode(1);
            resultVO.setSuccess(true);
        } else {
            resultVO.setCode(0);
            resultVO.setSuccess(false);
            resultVO.setMessage("修改失败");
            resultVO.setData(tbNote);
        }

        return resultVO;
    }

    @Override
    public ResultVO add(TbNote note) {
        ResultVO resultVO = new ResultVO();

        // 设置发布时间
        note.setPubTime(new Date());

        if (note.getLon() == null) {
            note.setLon(113.458366F);
        }

        if (note.getLat() == null) {
            note.setLat(34.772774F);
        }

        int affectedRows = noteDao.insertSelective(note);

        if (affectedRows > 0) {
            resultVO.setCode(1);
            resultVO.setSuccess(true);
        } else {
            resultVO.setCode(0);
            resultVO.setSuccess(false);
            resultVO.setMessage("添加失败");
            resultVO.setData(note);
        }

        return resultVO;
    }



    @Override
    public NoteVO view(Integer id) {
        return noteDao.detail(id);
    }

    @Override
    public ResultVO delete(Integer id) {
ResultVO resultVO=new ResultVO();
        int i = noteDao.deleteByPrimaryKey(id);
        if (i>0){
            resultVO=new ResultVO(1,"6666",true,"");
        }
        else {
            resultVO=new ResultVO(0,"6666",false,"");
        }
        return resultVO;
    }


}
