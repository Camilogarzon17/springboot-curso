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
    private static UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public static User save(User newUser) {
        return userRepository.save(newUser);
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

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public static User update(User newUser, Long id) {
        return userRepository.findById(id)
                .map(
                        user -> {
                            user.setEmail(newUser.getEmail());
                            user.setBirthDate(newUser.getBirthDate());
                            user.setName(newUser.getName());
                            return userRepository.save(user);
                        }
                ).get();
    }
}
