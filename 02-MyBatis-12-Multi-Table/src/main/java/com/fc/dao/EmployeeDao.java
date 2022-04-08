package com.fc.dao;



import com.fc.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    //一对一操作
    List<Employee> findAll();
//   List<Employee> findAll();
   
}
