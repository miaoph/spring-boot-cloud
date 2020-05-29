package com.miaoph.cn;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@ComponentScans({@ComponentScan("com.miaoph.cn.*")})
@MapperScan(basePackages = "com.miaoph.cn.mapper")
public class SpringBootCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCloudApplication.class, args);
    }

}
