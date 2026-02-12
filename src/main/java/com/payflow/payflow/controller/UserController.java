package com.payflow.payflow.controller;

import com.payflow.payflow.dto.CreateUserRequest;
import com.payflow.payflow.dto.UpdateUserRequest;
import com.payflow.payflow.dto.UserResponse;
import com.payflow.payflow.model.User;
import com.payflow.payflow.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> listUsers() {
        return userService.listUsers()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getBalance()
                )).toList();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request.name(), request.email());
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBalance()
        );
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable UUID id, @RequestBody UpdateUserRequest request) throws IOException {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteUser(@PathVariable UUID id) throws IOException {
        return userService.deleteUser(id);
    }
}

