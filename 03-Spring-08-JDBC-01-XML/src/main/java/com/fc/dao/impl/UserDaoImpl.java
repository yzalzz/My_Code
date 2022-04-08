package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
//通过Spring操作数据库
public class UserDaoImpl implements UserDao {
    //1.声明一个JdbcTemplate
   private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql="select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        return users;
    }















//    //这类似于QueryRunner
//    //它无法调用方法 要在applicationContext.xml中注入
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<User> findAll() {
//        //连接数据库
//        String sql="select * from user";
//
//        BeanPropertyRowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
//        List<User> query = jdbcTemplate.query(sql, mapper);
//
//        return query;
//    }
//        public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
}
