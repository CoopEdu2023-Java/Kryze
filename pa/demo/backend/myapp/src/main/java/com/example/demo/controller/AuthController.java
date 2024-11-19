package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginUser) {
        String response = authService.login(loginUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User registerUser) {
        String response = authService.register(registerUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}