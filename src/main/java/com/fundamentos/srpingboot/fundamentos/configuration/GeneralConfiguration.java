package com.fundamentos.srpingboot.fundamentos.configuration;

import com.fundamentos.srpingboot.fundamentos.bean.MyBeanWhitProperties;
import com.fundamentos.srpingboot.fundamentos.bean.MyBeanWhitPropertiesImplement;
import com.fundamentos.srpingboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@EnableConfigurationProperties(UserPojo.class)
@PropertySource("classpath:connection.properties")
@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastname;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;
    @Bean
    public MyBeanWhitProperties function(){
        return new MyBeanWhitPropertiesImplement(name, lastname);

    }
    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName(this.driver)
                .url(this.jdbcUrl)
                .username(this.username)
                .password(this.password)
                .build();
    }
}
