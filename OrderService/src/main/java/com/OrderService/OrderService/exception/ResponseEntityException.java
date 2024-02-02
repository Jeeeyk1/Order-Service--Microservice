package com.OrderService.OrderService.exception;


import com.OrderService.OrderService.Model.ErrorMessageModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomOrderException.class)
    public ResponseEntity<ErrorMessageModel> handleProductException(CustomOrderException exception) {
        String errorBasis = exception.getMessage();

        switch (errorBasis) {
            case "NOT_FOUND":
                return new ResponseEntity<>(new ErrorMessageModel().
                        builder().
                        errorMessage(exception.getMessage()).
                        errorCode(exception.getErrorCode()).
                        build(), HttpStatus.NOT_FOUND);
            case "INSUFICIENT_QUANTITY":
                return new ResponseEntity<>(new ErrorMessageModel()
                        .builder()
                        .errorMessage(exception.getErrorCode())
                        .errorCode(exception.getErrorCode())
                        .build(), HttpStatus.BAD_REQUEST);
            case "INTERNAL_SERVER_ERROR":
                return new ResponseEntity<>(new ErrorMessageModel()
                        .builder()
                        .errorMessage(exception.getMessage())
                        .errorCode(exception.getErrorCode())
                        .build()
                        , HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(new ErrorMessageModel().
                builder().
                errorMessage(exception.getMessage()).
                errorCode(exception.getErrorCode()).
                build(), HttpStatus.NOT_FOUND);

    }

}
