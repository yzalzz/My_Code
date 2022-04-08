package com.fc.dao.Impl;

import com.fc.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void increaseMoney(Integer id, Long money) {
      getJdbcTemplate().update("update account set money=money-? where id=?",money,id);
        System.out.println("加钱成功");
    }

    @Override
    public void decreaseMoney(Integer id, Long money) {
        getJdbcTemplate().update("update account set money=money-? where id=?",money,id);
        System.out.println("减钱成功");
    }



}
