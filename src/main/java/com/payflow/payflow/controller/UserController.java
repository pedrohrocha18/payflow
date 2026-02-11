package com.payflow.payflow.controller;

import com.payflow.payflow.dto.CreateUserRequest;
import com.payflow.payflow.dto.UserResponse;
import com.payflow.payflow.model.User;
import com.payflow.payflow.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserResponse createUser(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request.name(), request.email());
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBalance()
        );
    }
}

