package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Repository
@Mapper
public interface StudentDao {
    List<Student>findAll();
}
