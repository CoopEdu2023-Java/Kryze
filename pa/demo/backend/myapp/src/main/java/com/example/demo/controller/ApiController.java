package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/test")
    public ResponseEntity<String> testApi() {
        logger.info("Request Got:/test API");
        String response = "Hello, API!";
        logger.info("Response content:{}", response);
        return ResponseEntity.ok(response);
    }
}
