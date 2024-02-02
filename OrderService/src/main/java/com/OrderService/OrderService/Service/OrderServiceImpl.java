package com.OrderService.OrderService.Service;


import com.OrderService.OrderService.Entity.OrderEntity;
import com.OrderService.OrderService.Model.OrderRequest;
import com.OrderService.OrderService.Model.OrderResponse;
import com.OrderService.OrderService.Model.ProductResponse;
import com.OrderService.OrderService.Repository.OrderRepository;

import com.OrderService.OrderService.exception.CustomOrderException;
import com.OrderService.OrderService.external.client.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductService productService;

    public OrderResponse placeOrder(OrderRequest requestBody) {

        ProductResponse productResponse = productService.getProductById(requestBody.getProductId());
        log.info("Placing order {}" + productResponse);
        if (productResponse.getQuantity() < requestBody.getQuantity()) {
            throw new CustomOrderException("INSSUFICIENT PRODUCT QUANTITY", "INSUFFICIENT_QUANTITY", 401);

        }
        OrderEntity customerOrder = new OrderEntity().builder().orderStatus("CREATED").amount(requestBody.getAmount()).productId(requestBody.getProductId()).quantity(requestBody.getQuantity()).build();
        OrderResponse response = new OrderResponse();
        repository.save(customerOrder);
        productService.reduceQuantity(requestBody.getProductId(), requestBody.getQuantity());

        BeanUtils.copyProperties(customerOrder, response);

        return response;

    }
}
