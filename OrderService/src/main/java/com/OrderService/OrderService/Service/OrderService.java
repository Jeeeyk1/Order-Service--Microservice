package com.OrderService.OrderService.Service;

import com.OrderService.OrderService.Model.OrderRequest;
import com.OrderService.OrderService.Model.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderResponse placeOrder(OrderRequest requestBody);
}
