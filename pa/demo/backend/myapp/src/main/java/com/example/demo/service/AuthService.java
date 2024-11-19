package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;

    public String login(User userEntity) {
        User existUser = userRepository.findByUsernameAndPassword(userEntity.getUsername(), userEntity.getPassword());
        return jwtService.setToken(existUser);
    }

    public String register(User registerUser) {
        if (userRepository.existsByUsername(registerUser.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }

        userRepository.save(registerUser);

        return "Registration successful";
    }
}