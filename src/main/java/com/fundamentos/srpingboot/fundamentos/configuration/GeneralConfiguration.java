package com.fundamentos.srpingboot.fundamentos.configuration;

import com.fundamentos.srpingboot.fundamentos.bean.MyBeanWhitProperties;
import com.fundamentos.srpingboot.fundamentos.bean.MyBeanWhitPropertiesImplement;
import com.fundamentos.srpingboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
