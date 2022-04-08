package com.fc.test;

import com.fc.dao.DepartmentDao;
import com.fc.entity.Department;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class LazyTest {
    @Test
    public void test() {
        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);

        Department department = departmentDao.findByDepartmentId(5);

        System.out.println(department.getName());

        MyBatisUtil.commit();
    }

}
