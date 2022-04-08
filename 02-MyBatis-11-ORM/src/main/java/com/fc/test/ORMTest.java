package com.fc.test;

import com.fc.dao.AccountDao;
import com.fc.entity.Account;
import com.fc.entity.TAccount;
import com.fc.util.MyBatisUtil;
import lombok.Data;
import org.junit.Test;

import java.util.List;
public class ORMTest {
    @Test
    public void testFindByIdTAccount(){
        AccountDao mapper = MyBatisUtil.getMapper(AccountDao.class);

        TAccount byIdTAccount = mapper.findByIdTAccount(1);

        System.out.println(byIdTAccount);

        MyBatisUtil.commit();
    }
    @Test
    public void testFindById(){
        AccountDao mapper = MyBatisUtil.getMapper(AccountDao.class);

        Account id = mapper.findById(1);

        System.out.println(id);

        MyBatisUtil.commit();
    }
    @Test
    public  void  testFindAllMap(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> accountDaoAllMap = accountDao.findAllMap();

        for (Account account : accountDaoAllMap) {
            System.out.println(account);
        }
    }
@Test
    public void testFindAll(){
    AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

    List<Account> accountDaoAll = accountDao.findAll();

    for (Account account : accountDaoAll) {

        System.out.println(account);
    }
}












//    @Test
//    public void testFindAll(){
//        //测试ORM失效   第一种用as解决
//        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
//
//        List<Account> accountDaoAll = accountDao.findAll();
//
//        for (Account account : accountDaoAll) {
//            System.out.println(account);
//        }
//    }
//    @Test
//    //第二中方法resultMap
//    public void test(){
//        AccountDao mapper = MyBatisUtil.getMapper(AccountDao.class);
//        List<Account> onMap = mapper.findOnMap();
//
//        for (Account account : onMap) {
//            System.out.println(account);
//        }
//        MyBatisUtil.commit();
//    }
//
//    @Test
//    //第二中方法resultMap
//    public void testFindById(){
//        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
//
//        Account id = accountDao.findById(1);
//
//        System.out.println(id);
//
//        MyBatisUtil.commit();
//    }


























//    @Test
//    public void testFindById(){
//        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
//
//        List<TAccount> id = accountDao.findById(1);
//
//        MyBatisUtil.commit();
//
//        for (TAccount tAccount : id) {
//            System.out.println(tAccount);
//        }
//    }
//    @Test
//    public void testFindOnMap(){
//        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
//
//        List<Account> map = accountDao.findOnMap();
//
//        MyBatisUtil.commit();
//
//        for (Account account : map) {
//            System.out.println(account);
//        }
//    }
//    @Test
//    public void testFindAll(){
//        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
//
//        List<Account> all = accountDao.findAll();
//
//        MyBatisUtil.commit();
//
//        for (Account account : all) {
//            System.out.println(account);
//        }
//    }
}
