package com.essmp.web.manage.config.dao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyVetoException;

@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.evol.esdemo.dao")
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class DataSourceConfiguration {

    //@Value("${spring.datasource.driver}")
    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;

    //@Value("${spring.datasource.url}")
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUsername;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        //关闭连接后不自动commit，才是事务控制
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
