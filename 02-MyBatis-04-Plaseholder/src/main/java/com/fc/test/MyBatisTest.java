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
import java.util.List;

public class MyBatisTest {
    @Test
    public  void testFindByName(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            List<Student> name = mapper.findByName("小明");
            for (Student student : name) {
                System.out.println(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindById(){

        try {
            //将配置文件加载到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取链接
            SqlSession session = factory.openSession();

            //通过反射获取StudentDao的实体类
            StudentDao studentDao = session.getMapper(StudentDao.class);

            //调用方法
            List<Student> byId = studentDao.findById("1 or 1=1");

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
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sessionFactory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> studentDaoByAge = studentDao.findByAge("17 or 1 = 1");
            for (Student student : studentDaoByAge) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
