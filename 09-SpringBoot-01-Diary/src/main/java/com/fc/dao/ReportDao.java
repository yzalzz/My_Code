package com.fc.dao;

import com.fc.Vo.NoteVO;
import com.fc.entity.TbNote;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao {
    List<NoteVO> getMonth(Integer id);

    List<TbNote> getLocation(Integer id);
}
