package com.payflow.payflow.service;

import com.payflow.payflow.model.User;
import com.payflow.payflow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String helloWorld() {
        return "Hello World! =)";
    }

    public User createUser(String name, String email) {
        if (userRepository.getUserByMail(email) != null) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
        User user = User.builder()
                .id(UUID.randomUUID())
                .name(name)
                .email(email)
                .balance(BigDecimal.ZERO)
                .build();

        try {
            userRepository.addUser(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public List<User> listUsers() {
        return userRepository.getAllUsers();
    }

    public User findById(UUID id) {
        return userRepository.getUserById(id);
    }
}
