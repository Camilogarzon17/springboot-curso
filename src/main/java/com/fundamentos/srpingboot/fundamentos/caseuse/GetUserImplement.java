package com.fundamentos.srpingboot.fundamentos.caseuse;

import com.fundamentos.srpingboot.fundamentos.entity.User;
import com.fundamentos.srpingboot.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
