package com.fc.Service;

import com.fc.entity.TbNoteType;
import com.fc.vo.ResultVo;

public interface NoteTypeService {
    ResultVo list(Integer pageNum, Integer pageSize, Integer id);

    ResultVo addOrUpdate(TbNoteType tbNoteType);

    ResultVo delete(Integer id);

}
