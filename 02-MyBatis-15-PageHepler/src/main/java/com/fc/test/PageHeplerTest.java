package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import org.junit.Test;

import java.util.List;

public class PageHeplerTest {

           @Test
   public void testPageInfo(){
      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//开启分页
      PageHelper.startPage(1,5);

      List<Student> students = studentDao.findAll();
//封装PageInfo
      PageInfo<Student> pageInfo = new PageInfo<>(students);

      System.out.println(pageInfo);
   }
   @Test
   public void test(){
      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

      //分页 需要声明当前页pageNum和每页显示多少条内容pageSize
      PageHelper.startPage(5,2);

      List<Student> all = studentDao.findAll();

      for (Student student : all) {
         System.out.println(student);
      }
      MyBatisUtil.commit();

   }

   }













