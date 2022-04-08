package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class AnnotationsTest {
    @Test
    public void testUpdate(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(26);
        student.setInfo("jjjj");

        int affectRows = studentDao.update(student);

        System.out.println(affectRows);
        MyBatisUtil.commit();
    }
    @Test
    public void testDelete(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        int affectRows = studentDao.delete(25);

        System.out.println(affectRows);

        MyBatisUtil.commit();
    }
    @Test
    public void testInsert(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setName("张国伟");
        student.setAge(15);
        student.setGender("男");

        int affectRows = studentDao.insert(student);

        System.out.println(affectRows);
    }
    @Test
    public void testFindById(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student id = studentDao.findById(1);

        System.out.println(id);

        MyBatisUtil.commit();
    }
    @Test
    public void testFindAll(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
