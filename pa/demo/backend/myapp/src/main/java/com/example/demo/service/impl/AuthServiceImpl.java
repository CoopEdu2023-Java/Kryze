package com.example.demo.service.impl;
import com.example.demo.service.*;
import com.example.demo.entity.User;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ExceptionEnum;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.dto.*;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public String login(LoginDto loginDto) {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();

        User existUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new BusinessException(ExceptionEnum.USER_DOES_NOT_EXIST));

        if (!bCryptPasswordEncoder.matches(password, existUser.getPassword())) {
            throw new BusinessException(ExceptionEnum.WRONG_PASSWORD);
        }

        return jwtService.setToken(existUser);
    }

    @Override
    public void register(RegisterDto registerDto) {
        String username = registerDto.getUsername();
        String password = bCryptPasswordEncoder.encode(registerDto.getPassword());

        if (userRepository.existsByUsername(username)) {
            throw new BusinessException(ExceptionEnum.USER_EXISTS);
        }

        userRepository.save(new User(username, password));
    }
}