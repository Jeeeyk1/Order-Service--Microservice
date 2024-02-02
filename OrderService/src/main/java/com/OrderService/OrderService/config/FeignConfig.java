package com.OrderService.OrderService.config;


import com.OrderService.OrderService.external.decoder.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    ErrorDecoder errorDecoder(){
        return new CustomErrorDecoder();
    }
}
