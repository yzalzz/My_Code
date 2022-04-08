package com.fc.test;

import com.fc.config.TxtConfig;
import com.fc.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropagateTest {
    @Test
    public void testPropagate(){
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxtConfig.class);

            AccountService accountService = applicationContext.getBean(AccountService.class);

            accountService.add("海绵宝宝", "太平洋比基尼海滩比奇堡镇贝壳街124号的波萝屋");
        }
    }

