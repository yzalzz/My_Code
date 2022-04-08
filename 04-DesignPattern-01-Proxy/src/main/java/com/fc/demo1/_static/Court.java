package com.fc.demo1._static;

import org.junit.Test;

public class Court {
    @Test
    public void test(){
       Lawsuit parties = new Parties();
        //因为Lawyer里没有无参构造只有有参构造所以要传递一个参数

        Lawsuit lawyer = new Lawyer(parties);

        lawyer.submit();
        lawyer.defend();



    }
}
