package com.OrderService.OrderService.external.decoder;

import com.OrderService.OrderService.Model.ErrorMessageModel;
import com.OrderService.OrderService.exception.CustomOrderException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();

        log.info("::{}", response.request().body());
        log.info("::{}", response.request().url());


        try {
            objectMapper.readValue(response.body().asInputStream(), ErrorMessageModel.class);
        } catch (IOException e) {
            throw new CustomOrderException("Internal Server Error","INTERNAL_SERVER_ERROR",500);
        }
        return null;
    }

}
