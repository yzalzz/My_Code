package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
    //查询年龄小于指定年龄的人
     List <Student> findLessThanAge(Integer age);
     List<Student>findGreaterThanAge(Integer age);
      List <Student> big(Integer age);
      List<Student> list(Integer age);
}
