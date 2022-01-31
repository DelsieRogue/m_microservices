package com.mustafin.learningtask.goodsmicroservice.exceptions.classes;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}
