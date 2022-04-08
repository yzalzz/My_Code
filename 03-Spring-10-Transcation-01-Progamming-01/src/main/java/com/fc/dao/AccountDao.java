package com.fc.dao;

public interface AccountDao {

    void increaseMoney(Integer id , Long money);

    void decreaseMoney(Integer id , Long money);
}
