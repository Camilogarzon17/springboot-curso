package com.fundamentos.srpingboot.fundamentos.caseuse;

import com.fundamentos.srpingboot.fundamentos.entity.User;
import com.fundamentos.srpingboot.fundamentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;
    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public static User update(User newUser, Long id) {
        return UserService.update(newUser, id);
    }
}
