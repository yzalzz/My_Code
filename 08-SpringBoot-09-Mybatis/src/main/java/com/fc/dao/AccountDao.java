package com.fc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountDao {
    //加钱
    void increase(@Param("id") Integer id, @Param("money") Integer money);
    //减钱
    void decrease(@Param("id") Integer id, @Param("money") Integer money);
}
