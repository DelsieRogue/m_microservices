package com.mustafin.learningtask.goodsmicroservice.exceptions.controller;

import com.mustafin.learningtask.goodsmicroservice.exceptions.classes.ProductNotFoundException;

import com.mustafin.learningtask.goodsmicroservice.exceptions.classes.SaveProductException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler({ProductNotFoundException.class, SaveProductException.class})
    public ResponseEntity<String> handleProductNotFoundException(Exception e) {
        String response = e.getMessage();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
