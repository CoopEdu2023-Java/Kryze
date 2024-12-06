package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.*;
import com.example.demo.service.impl.*;;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthServiceImpl authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginUser) {
        return authService.login(loginUser);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterDto registerUser) {
        authService.register(registerUser);
    }
}