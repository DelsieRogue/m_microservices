package com.mustafin.learningtask.adminmicroservice.feignclient;

import com.mustafin.learningtask.adminmicroservice.exception.GoodsFeignClientException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomErrorDecoder implements ErrorDecoder{
    @Override
    public Exception decode(String s, Response response) {
        return new GoodsFeignClientException("Method: " + s + " return status: " + response.status(), response);
    }
}
