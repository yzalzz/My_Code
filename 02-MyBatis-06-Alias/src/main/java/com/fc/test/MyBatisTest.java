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
import java.io.InputStreamReader;
import java.util.List;

public class MyBatisTest {
    @Test
    public  void testFindAll(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            List<Student> all = mapper.findAll();
            for (Student student : all) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void testFindById(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            List<Student> byId = mapper.findById(1);
            for (Student student : byId) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindByAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            List<Student> byAge = mapper.findByAge(18);
            for (Student student : byAge) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void testFindById(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = build.openSession();
//            StudentDao mapper = session.getMapper(StudentDao.class);
//            List<Student> byId = mapper.findById(6);
//            for (Student student : byId) {
//                System.out.println(student);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testFindAll(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = build.openSession();
//            StudentDao mapper = session.getMapper(StudentDao.class);
//            List<Student> all = mapper.findAll();
//            for (Student student : all) {
//                System.out.println(student);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
