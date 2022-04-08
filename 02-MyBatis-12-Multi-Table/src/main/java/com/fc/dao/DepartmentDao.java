package com.fc.dao;

import com.fc.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
     //根据部门ID查出对应的所有员工
     Department findById(@Param("id") Integer id);

//     List<Department> findById(@Param("id")Integer id);
}
