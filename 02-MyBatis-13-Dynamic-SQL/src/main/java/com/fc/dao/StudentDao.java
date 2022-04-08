package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao   {
 List<Student>findAll();

 //模糊查询
    List <Student>findByKeyWord(@Param("name") String name , @Param("info") String info);

List<Student>findByStudent(Student student);

int update(Student student);

List<Student>findByStudentOnTrim(Student student);
//删除多个
    //(Integer...ids)不定长参数/可变长参数 里面可以传递0个，1个，2个，或多个参数 只能用在形参列表中最后一个参数位置上 并且只能有一个
int delete(Integer...ids);













//    List <Student> findAll();
//    //模糊查询
//     List<Student>findByKeyword(@Param("name") String name,@Param("info") String info);
//
//     //根据条件查询学生
//    List<Student> findByStudent(Student student);
//    //修改学生
//    int update(Student student);
//    //
//    List<Student> findByStudentOnTrim(Student student);
//    //
//    int updateOnTrim(Student student);
//    //删除多个
//    //(Integer...ids) 不定长参数/可变长参数，可以传递的参数为0个，1个，或者多个 只能用在形参列表中的最后一个参数的位置，并且只能有一个
//     int deleteMore(Integer...ids);
}
