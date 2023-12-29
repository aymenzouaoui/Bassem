package com.example.demo.services;
import com.example.demo.models.User;

import java.util.Optional;

public interface UserService {
    User registerUser(User user);

    User loginUser(String cin, String password);

    Optional<User> getUserById(String userId);

    User updateUser(User user);

    void deleteUser(String userId);
}
