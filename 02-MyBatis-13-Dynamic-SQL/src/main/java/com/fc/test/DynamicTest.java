package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class DynamicTest{
   @Test
   public void testDelete(){
      StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

      int affectRows = mapper.delete(20,21,22);

      System.out.println(affectRows);

      MyBatisUtil.commit();
   }
   @Test
   public void testFindByStudentOnTrim(){
      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

      Student student = new Student();

student.setName("小明");

student.setInfo("我爱你");
      List<Student> byStudentOnTrim = studentDao.findByStudentOnTrim(student);

      for (Student student1 : byStudentOnTrim) {
         System.out.println(student1);
      }
   }
   @Test
   public void testUpdate(){
      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

      Student student = new Student();

      student.setId(11);

      student.setName("阎田田");

      student.setInfo("吃鸡");
      int affectRows = studentDao.update(student);

      System.out.println(affectRows);

      MyBatisUtil.commit();
   }
   @Test
   public void testFindByStudent(){
      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

      Student student = new Student();
      student.setName("小明");
      student.setInfo("666");
      List<Student> byStudent = studentDao.findByStudent(student);

      for (Student student1 : byStudent) {
         System.out.println(student1);
      }
      MyBatisUtil.commit();
   }
   @Test
   public void testFindByKeyWord(){
      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

      List<Student> byKeyWord = studentDao.findByKeyWord("%明%", null);

      for (Student student : byKeyWord) {
         System.out.println(student);
      }
      MyBatisUtil.commit();
   }
   @Test
   public void testFindAll(){
      StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

      List<Student> all = mapper.findAll();

      for (Student student : all) {
         System.out.println(student);
      }
      MyBatisUtil.commit();
   }















//   @Test
//   public void testDelete(){
//      StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);
//
//      int affectRows = mapper.deleteMore(15);
//
//      System.out.println(affectRows);
//
//      MyBatisUtil.commit();
//   }
//
//   @Test
//   public void testUpdateOnTrim(){
//      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//
//      Student student = new Student();
//
//      student.setId(10);
//
//      student.setName("肖志龙");
//
//      student.setAge(66);
//
//      student.setInfo("吹牛");
//
//      int affectRows = studentDao.update(student);
//
//      System.out.println("受影响的行数："+affectRows);
//
//      MyBatisUtil.commit();
//
//
//   }
//   @Test
//   public void testFindByStudentOnTrim(){
//      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//
//      Student student = new Student();
//
//      List<Student> byStudentOnTrim = studentDao.findByStudentOnTrim(student);
//
//      for (Student student1 : byStudentOnTrim) {
//         System.out.println(student1);
//      }
//   }
//   @Test
//   public void testUpdate(){
//      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//
//      Student student = new Student();
//
//      student.setId(9);
//
//      student.setName("孟志斌");
//
//      student.setAge(55);
//
//      student.setInfo("蹲坑");
//
//      int affectRows = studentDao.update(student);
//
//      System.out.println("受影响的行数："+affectRows);
//
//      MyBatisUtil.commit();
//
//
//   }
//   @Test
//   public void testFindByStudent(){
//      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//
//      Student student = new Student();
//
//      student.setId(9);
//
//     student.setName("小明");
//
//     student.setInfo("我爱你");
//
//      List<Student> byStudent = studentDao.findByStudent(student);
//
//      for (Student student1 : byStudent) {
//         System.out.println(student1);
//      }
//      MyBatisUtil.commit();
//   }
//   @Test
//   public void testFindByKeyword(){
//      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//
//      List<Student> keyword = studentDao.findByKeyword("%小%","%我%");
//
//      for (Student student : keyword) {
//
//         System.out.println(student);
//      }
//
//      MyBatisUtil.commit();
//   }
//
//   @Test
//   public void testFindAll(){
//      StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//
//      List<Student> all = studentDao.findAll();
//
//      MyBatisUtil.commit();
//
//      for (Student student : all) {
//         System.out.println(student);
//      }
//
//   }
//

   }













