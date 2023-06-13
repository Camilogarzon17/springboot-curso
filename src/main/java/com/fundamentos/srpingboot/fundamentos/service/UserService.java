package com.fundamentos.srpingboot.fundamentos.service;

import com.fundamentos.srpingboot.fundamentos.entity.User;
import com.fundamentos.srpingboot.fundamentos.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOG.info("Insert to " + user ))
                .forEach(userRepository::save);
                //.forEach(user -> userRepository.save(user));
    }

    public List<User> getAllUsers(){
       return userRepository.findAll();
    }
}
