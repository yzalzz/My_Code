package com.fc.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

import javax.sql.DataSource;

//创建一个类去继承PooledDataSourceFactory 来实现替换第三方数据源
public class DruidDataSourceFactory extends PooledDataSourceFactory {
    //重写无参构造方法来替换数据源
    public DruidDataSourceFactory(){
        //替换数据源为Druid
        this.dataSource=new DruidDataSource();

    }

}
