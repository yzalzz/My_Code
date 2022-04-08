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

public class MybatisTest {
    @Test
    public  void  testFindAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            List<Student> age = mapper.findAge(17);
            for (Student student : age) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void  testFindById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = build.openSession();

            StudentDao mapper = session.getMapper(StudentDao.class);

            List<Student> students = mapper.findById(2);
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFinAll(){

        try {
            //将配置文件加载到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);

            //获取链接
            SqlSession session = build.openSession();

            //通过反射获取实体类
            StudentDao mapper = session.getMapper(StudentDao.class);

            //掉方法
            List<Student> all = mapper.findAll();

            for (Student student : all) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
