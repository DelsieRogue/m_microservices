package com.mustafin.learningtask.adminmicroservice.exception;


import feign.Response;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GoodsFeignClientException extends Exception{
    HttpStatus httpStatus;

    public GoodsFeignClientException(String message, Response response){
        super(message);
        this.httpStatus = HttpStatus.valueOf(response.status());
    }
}
