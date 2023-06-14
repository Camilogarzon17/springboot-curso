package com.fundamentos.srpingboot.fundamentos.caseuse;

import com.fundamentos.srpingboot.fundamentos.entity.User;
import com.fundamentos.srpingboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;
    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return UserService.save(newUser);
    }
}
