package com.fc.service;

public interface AccountService {
    //转账 from(id)减钱  to(id)加钱   money多少元
    void transfer(Integer from,Integer to,Integer money);
}
