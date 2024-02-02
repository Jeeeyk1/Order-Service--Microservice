package com.OrderService.OrderService.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessageModel {

    private String errorCode;
    private String errorMessage;
    private int status;
}