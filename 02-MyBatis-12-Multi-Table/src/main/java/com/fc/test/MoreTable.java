package com.fc.test;

import com.fc.dao.DepartmentDao;
import com.fc.dao.EmployeeDao;
import com.fc.dao.StudentDao;
import com.fc.dao.SubjectDao;
import com.fc.entity.Department;
import com.fc.entity.Employee;
import com.fc.entity.Student;
import com.fc.entity.Subject;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class MoreTable {
    @Test
    public void testFindAllWithSubject(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> allWithSubject = mapper.findAllWithSubject();

        for (Student student : allWithSubject) {
            System.out.println(student);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testFindById(){
        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);

        Department byId = departmentDao.findById(5);

        System.out.println(byId);

        MyBatisUtil.commit();
    }
    @Test
    public void testFindAll(){
        EmployeeDao employeeDao = MyBatisUtil.getMapper(EmployeeDao.class);

        List<Employee> all = employeeDao.findAll();

        for (Employee employee : all) {
            System.out.println(employee);
        }
        MyBatisUtil.commit();
    }









//    @Test
//    public void testFindAllMap(){
//        SubjectDao subjectDao = MyBatisUtil.getMapper(SubjectDao.class);
//
//        List<Subject> all = subjectDao.findAll();
//
//        for (Subject subject : all) {
//            System.out.println(subject);
//        }
//        MyBatisUtil.commit();
//    }
//    @Test
//    public void testFindById(){
//        DepartmentDao mapper = MyBatisUtil.getMapper(DepartmentDao.class);
//
//        Department byId = mapper.findById(5);
//
//        System.out.println(byId);
//
//        MyBatisUtil.commit();
//    }
//    @Test
//    public void testFindAll(){
//        EmployeeDao mapper = MyBatisUtil.getMapper(EmployeeDao.class);
//
//        List<Employee> all = mapper.findAll();
//
//        for (Employee employee : all) {
//            System.out.println(employee);
//        }
//        MyBatisUtil.commit();
//    }
//    @Test
//    public void test(){
//        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);
//
//        List<Student> allWithSubject = mapper.findAllWithSubject();
//
//        for (Student student : allWithSubject) {
//            System.out.println(student);
//        }
//        MyBatisUtil.commit();
//    }
//






//   @Test
//   public void testFindAll(){
//       EmployeeDao employeeDao = MyBatisUtil.getMapper(EmployeeDao.class);
//
//       List<Employee> all = employeeDao.findAll();
//
//       MyBatisUtil.commit();
//
//       for (Employee employee : all) {
//           System.out.println(employee);
//       }
//   }
//










//    @Test
//public void testFindAllWithSubject(){
//        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
//
//        List<Student> allWithSubject = studentDao.findAllWithSubject();
//
//        MyBatisUtil.commit();
//
//        for (Student student : allWithSubject) {
//
//            System.out.println(student);
//        }
//    }
//
//    @Test
//    public void testFindById(){
//        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);
//
//        Department id = departmentDao.findById(5);
//
//        MyBatisUtil.commit();
//
//        System.out.println(id);
//    }
//    @Test
//    public void test(){
//        EmployeeDao employeeDao = MyBatisUtil.getMapper(EmployeeDao.class);
//
//        List<Employee> all = employeeDao.findAll();
//
//        MyBatisUtil.commit();
//
//        for (Employee employee : all) {
//
//            System.out.println(employee);
//        }
//    }
}
