package com.mustafin.learningtask.adminmicroservice.exception.controller;


import com.mustafin.learningtask.adminmicroservice.exception.GoodsFeignClientException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler(GoodsFeignClientException.class)
    public ResponseEntity<String> handleProductNotFoundException(GoodsFeignClientException e) {
        String response = e.getMessage();
        return new ResponseEntity<>(response, e.getHttpStatus());
    }

}
