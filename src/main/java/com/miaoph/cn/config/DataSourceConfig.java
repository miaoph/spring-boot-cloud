package com.miaoph.cn.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private String MAPPER_LOCTIONS[] = new String[]{"classpath:mapper/*.xml"};


    @Value("${spring.datasource.druid.master.url}")
    private String dataSourceUrl = null ;

    @Value("${spring.datasource.druid.master.password}")
    private String dataSourcePassword = null ;

    @Value("${spring.datasource.druid.master.username}")
    private String dataSourceUsername = null ;

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriverClassName = null ;

    private String SQL_VALIDATE = "SELECT id FROM ph_user WHERE id = 1;";

    @Bean
    public DataSource dateSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setConnectionTestQuery(SQL_VALIDATE);
        dataSource.setJdbcUrl(dataSourceUrl);
        dataSource.setPassword(dataSourcePassword);
        dataSource.setUsername(dataSourceUsername);
        dataSource.setConnectionInitSql(SQL_VALIDATE);
        dataSource.setMinimumIdle(32);
        dataSource.setIdleTimeout(3600 * 1 * 1000);
        dataSource.setMaximumPoolSize(512);
        dataSource.setPoolName("account-datasource-poll");
        dataSource.setConnectionTimeout(30*1000);
        dataSource.setMaxLifetime(3600 * 2 * 1000);
        dataSource.setReadOnly(Boolean.FALSE);
        return dataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        MybatisProperties mybatisProperties = new MybatisProperties();
        mybatisProperties.setMapperLocations(MAPPER_LOCTIONS);
        factory.setMapperLocations(mybatisProperties.resolveMapperLocations());
        return factory.getObject();
    }
}
