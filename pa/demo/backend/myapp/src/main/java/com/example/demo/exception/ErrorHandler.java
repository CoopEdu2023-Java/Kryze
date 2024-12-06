package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ResponseDto;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseDto<Void> exceptionHandler(Exception e) {
        System.out.println("Exception: " + e);
        return new ResponseDto<Void>(1000, "Unknown Error: " + e.getMessage(), null);
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseDto<Void> exceptionHandler(BusinessException e) {
        System.out.println("Exception: " + e);
        return new ResponseDto<Void>(e.getCode(), "Error: " + e.getMessage(), null);
    }
}
