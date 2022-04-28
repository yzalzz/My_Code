package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository  //将当前dao层数据注入容器
public class UserDaoimpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<>(User.class),id );
    }

    @Override
    public Integer findCount() {
        //查总数  要把查到的数字映射为Integer类型
        return jdbcTemplate.queryForObject("select count(*) from user",Integer.class);
    }

    @Override
    public int insert(User user) {
        return jdbcTemplate.update("insert into user(username,password) value (?,?)",user.getUsername(),user.getPassword());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("update user set username = ?, password = ? where id = ?", user.getUsername(), user.getPassword(), user.getId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("delete from user where id = ?", id);
    }
}
