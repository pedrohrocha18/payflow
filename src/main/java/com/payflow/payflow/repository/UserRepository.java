package com.payflow.payflow.repository;

import com.payflow.payflow.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}
