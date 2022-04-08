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
import java.util.List;

public class MyBatisTest {
    //
    @Test
    public void testUpdate(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            Student student = new Student();
            student.setId(6);
            student.setInfo("11111");
            int update = mapper.update(student);
            System.out.println(update);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
public  void testKeyWord(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            List<Student> byKeyword = mapper.findByKeyword("%明%");
            for (Student student : byKeyword) {
                System.out.println(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    //删除
    public void testDelete(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            int affect= mapper.delete(2);
            session.commit();
            session.close();
            System.out.println(affect);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //插入
    @Test
    public void testInsert(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            Student student = new Student();
            student.setName("小虎");
            student.setAge(16);
            student.setGender("男");
            student.setBirthday(new Date(2002,12,13));
            student.setInfo("kkk");
            int insert = mapper.insert(student);
            System.out.println(insert);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //根据id查询
    @Test
    public void testFindById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            Student byId = mapper.findById(2);
            System.out.println(byId);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //查询全部
    @Test
    public void testFindAll(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            List<Student> all = mapper.findAll();
            for (Student student : all) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
