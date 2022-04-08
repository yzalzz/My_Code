package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.dao.UserDao;
import com.fc.entity.Student;
import com.fc.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testUser(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);
            List<User> users = userDao.findAll();
            for (User user : users) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void testUser(){
//
//        try {
//            //将配置文件加载到流、
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            //获取工厂对象‘
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = factory.openSession();
//            UserDao userDao = session.getMapper(UserDao.class);
//            List<User> users = userDao.findAll();
//            for (User user : users) {
//                System.out.println(user);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    @Test
    public void testAdd(){

        try {
            //将配置文件加载到流
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);

            //获取链接
            SqlSession session = build.openSession();

            //通过反射获取接口的实现类
            UserDao userDao = session.getMapper(UserDao.class);

            //调用指定的sql语句
            int affectRows = userDao.add();

            System.out.println(affectRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void testAdd(){
//
//        try {
//            //将配置文件加载到流
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            //获取工厂对象
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            //获取链接
//            SqlSession session = sqlSessionFactory.openSession();
//
//            //通过映射获取接口中的实现类
//            UserDao userDao = session.getMapper(UserDao.class);
//
//            //调用指定的sql语句
//            int affectRows = userDao.add();
//
//            //提交
//            session.commit();
//
//            System.out.println(affectRows);
//
//            //关闭
//            session.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testAdd(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = factory.openSession();
//            UserDao mapper = session.getMapper(UserDao.class);
//            int affectRows = mapper.add();
//            session.commit();
//
//            System.out.println(affectRows);
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testUser(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = factory.openSession();
//            UserDao mapper = session.getMapper(UserDao.class);
//            List<User> all = mapper.findAll();
//            for (User user : all) {
//                System.out.println(user);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//








    @Test
    public void  test(){
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
    //    @Test
//    public void  test(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = factory.openSession();
//            StudentDao mapper = session.getMapper(StudentDao.class);
//            List<Student> students = mapper.findAll();
//            for (Student student : students) {
//                System.out.println(student);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void test(){
//
//        try {
//            //加载配置文件
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            //获取工厂
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            //获取链接
//            SqlSession session = factory.openSession();
//
//            //通过反射获取接口的实现类
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            //调用指定的sql语句、
//            List<Student> students = studentDao.findAll();
//
//            for (Student student : students) {
//                System.out.println(student);
//            }
//
//
//            //提交
//            session.commit();
//
//            //关闭
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
