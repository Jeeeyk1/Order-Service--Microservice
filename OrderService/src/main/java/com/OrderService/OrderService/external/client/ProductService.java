package com.OrderService.OrderService.external.client;

import com.OrderService.OrderService.Model.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "PRODUCT-SERVICE/api/products")
public interface ProductService {

    @PutMapping("/reduceQuantity/{id}")
    void reduceQuantity(@PathVariable long id, @RequestParam long quantity);
    @GetMapping("/{id}")
    ProductResponse getProductById(@PathVariable Long id);
}
