package com.fc.dao;

import com.fc.entity.Account;
import com.fc.entity.TAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountDao {


List<Account>findAll();
 List<Account>findAllMap();
 Account findById(@Param("id") Integer id);
    TAccount findByIdTAccount(@Param("id") Integer id);





//    List<Account>findAll();
//   List<Account> findOnMap();
//   Account findById(@Param("id") Integer id);




//    List<Account> findAll();
//    List<Account> findAll();
//     List<Account>findOnMap();
//     List<TAccount>findById(@Param("id")Integer tId);
}
