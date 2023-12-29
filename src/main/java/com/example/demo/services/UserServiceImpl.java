package com.example.demo.services;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        // Check if the user with the given username (cin) already exists
        if (userRepository.findByCin(user.getCin()) != null) {
            // You might want to handle the case where the username is already taken
            return null;
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user to the database
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String cin, String password) {
        User user = userRepository.findByCin(cin);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null; // Login failed
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User updateUser(User user) {
        // Implement logic to update user details
        // You may want to add validation or additional checks here
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    // You can add more methods as needed based on your application requirements

    // ... rest of the class
}
