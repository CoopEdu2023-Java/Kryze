package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ExceptionEnum;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/auth")
    public String auth(Authentication auth) {
        return auth.getName();
    }
    @GetMapping("/error")
    public void error() {
        throw new BusinessException(ExceptionEnum.USER_DOES_NOT_EXIST);
    }
}
