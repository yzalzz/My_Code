package com.fc.dao;

import com.fc.Vo.NoteVO;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteExample;
import java.util.List;

import com.fc.entity.TbNoteTypeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("noteDao")
public interface TbNoteMapper {
    long countByExample(TbNoteExample example);

    int deleteByExample(TbNoteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbNote record);

    int insertSelective(TbNote record);

    List<TbNote> selectByExampleWithBLOBs(TbNoteExample example);

    List<TbNote> selectByExample(TbNoteTypeExample example);

    TbNote selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbNote record, @Param("example") TbNoteExample example);

    int updateByExampleWithBLOBs(@Param("record") TbNote record, @Param("example") TbNoteExample example);

    int updateByExample(@Param("record") TbNote record, @Param("example") TbNoteExample example);

    int updateByPrimaryKeySelective(TbNote record);

    int updateByPrimaryKeyWithBLOBs(TbNote record);

    int updateByPrimaryKey(Integer record);

    List<TbNote> findByPageAndUserId(@Param("userId") Integer userId, @Param("id") Integer id, @Param("title") String title, @Param("date") String date);

    TbNote findAll(Integer id);

    List<NoteVO> findDateInfo(Integer userId);

    List<NoteVO> findTypeInfo(Integer userId);

    NoteVO detail(Integer id);
}