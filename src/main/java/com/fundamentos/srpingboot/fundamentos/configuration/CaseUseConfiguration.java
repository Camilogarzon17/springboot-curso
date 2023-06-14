package com.fundamentos.srpingboot.fundamentos.configuration;

import com.fundamentos.srpingboot.fundamentos.caseuse.GetUser;
import com.fundamentos.srpingboot.fundamentos.caseuse.GetUserImplement;
import com.fundamentos.srpingboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService ){
        return new GetUserImplement(userService);
    }
}
