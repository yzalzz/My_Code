package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
     List<Student>findByAge(String age);
     List <Student> findById(String id);
     List<Student>findByName(String name);
}
