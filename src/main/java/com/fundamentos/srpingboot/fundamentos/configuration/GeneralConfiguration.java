package com.fundamentos.srpingboot.fundamentos.configuration;

import com.fundamentos.srpingboot.fundamentos.bean.MyBeanWhitProperties;
import com.fundamentos.srpingboot.fundamentos.bean.MyBeanWhitPropertiesImplement;
import com.fundamentos.srpingboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@EnableConfigurationProperties(UserPojo.class)
@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastname;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWhitProperties function(){
        return new MyBeanWhitPropertiesImplement(name, lastname);

    }
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
