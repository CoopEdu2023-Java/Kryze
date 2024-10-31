package com.example.myapp.controller;

import com.example.myapp.model.User;
import com.example.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userService.findUserByUsername(user.getUsername()) != null) {
            return "User already exists!";
        }
        userService.registerUser(user);
        return "User registered successfully!";
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to the home page!";
    }
}
