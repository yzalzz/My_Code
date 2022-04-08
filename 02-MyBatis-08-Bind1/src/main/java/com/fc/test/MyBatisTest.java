package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;

public class MyBatisTest{
    @Test
    public void testInsert(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            Student student = new Student();
            student.setName("小龙");
            student.setAge(15);
            student.setGender("男");
            student.setBirthday(new Date(2002,12,12));
            student.setInfo("喜欢你");
            int affect = mapper.insert(student);
            session.commit();
            session.close();
            System.out.println(affect);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindByIdAndGender(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            HashMap<Object, Object> map = new HashMap<>();
            map.put("id",1);
            map.put("gender","男");
            Student gender = mapper.findByIdAndGender(map);
            System.out.println(gender);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testFindByNameAndAge(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            Student student = mapper.findByNameAndAge("小明", 18);
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindByIdAndAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            Student byIdAndAge = mapper.findByIdAndAge(2, 17);
            System.out.println(byIdAndAge);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testFindByIdAndName(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            Student student = mapper.findByIdAndName(1, "小明");
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

















//    @Test
//    public void testFindByNameAndAge(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = build.openSession();
//            StudentDao mapper = session.getMapper(StudentDao.class);
//            Student student = mapper.findByNameAndAge("小明", 18);
//            System.out.println(student);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public  void testFindByIdAndAge(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = build.openSession();
//            StudentDao mapper = session.getMapper(StudentDao.class);
//            Student byIdAndAge = mapper.findByIdAndAge(1, 18);
//            System.out.println(byIdAndAge);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testFindByIdAndName(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = build.openSession();
//            StudentDao mapper = session.getMapper(StudentDao.class);
//            Student student = mapper.findByIdAndName(1, "小明");
//            System.out.println(student);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
