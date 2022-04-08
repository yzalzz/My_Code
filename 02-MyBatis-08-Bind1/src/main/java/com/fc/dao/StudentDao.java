package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.Map;

public interface StudentDao {
     Student findByIdAndName(Integer id , String name);
     Student findByIdAndAge(Integer id,Integer age);
     Student findByNameAndAge(@Param("name")String name,@Param("age")Integer age);
     Student findByIdAndGender(HashMap<Object, Object> map);
     int insert(Student student);
//     Student findByIdAndName(Integer id , String name);
//     Student findByIdAndAge(Integer id ,Integer age  );
//     Student findByNameAndAge(@Param("name")String name,@Param("age")Integer age);
}
