package com.example.demo.controllers;

import com.example.demo.models.user;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<user> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getById{id}")
    public Optional<user> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public user createUser(@RequestBody user User) {
        return userService.createUser(User);
    }

    @PutMapping("/update{id}")
    public user updateUser(@PathVariable String id, @RequestBody user updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/delete{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}

