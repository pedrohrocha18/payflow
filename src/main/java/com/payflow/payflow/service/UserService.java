package com.payflow.payflow.service;

import com.payflow.payflow.dto.UpdateUserRequest;
import com.payflow.payflow.dto.UserResponse;
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

    public UserResponse findById(UUID id) {
        User user = userRepository.getUserById(id);

        return new UserResponse(user.getId(), user.getName(),
                user.getEmail(), user.getBalance());
    }

    public UserResponse updateUser(UUID id, UpdateUserRequest request) throws IOException {
        BigDecimal newBalance = request.balance();

        User updateUser = userRepository.updateUser(id, newBalance);

        return new UserResponse(
                updateUser.getId(),
                updateUser.getName(),
                updateUser.getEmail(),
                updateUser.getBalance()
        );
    }

    public UserResponse deleteUser(UUID id) throws IOException {
        User userdeleted = userRepository.deleteById(id);

        return new UserResponse(userdeleted.getId(), userdeleted.getName(), userdeleted.getEmail(), userdeleted.getBalance());
    }
}
