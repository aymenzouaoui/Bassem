package com.example.demo.services;

import com.example.demo.models.user;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<user> getUserById(String id) {
        return userRepository.findById(id);
    }

    public user createUser(user User) {
        return userRepository.save(User);
    }

    public user updateUser(String id, user updatedUser) {
        if (userRepository.existsById(id)) {
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}