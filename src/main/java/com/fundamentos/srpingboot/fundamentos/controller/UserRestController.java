package com.fundamentos.srpingboot.fundamentos.controller;

import com.fundamentos.srpingboot.fundamentos.caseuse.GetUser;
import com.fundamentos.srpingboot.fundamentos.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //create, get,  delete, update
    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }
}
