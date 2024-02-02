package com.OrderService.OrderService.Controller;


import com.OrderService.OrderService.Model.OrderRequest;
import com.OrderService.OrderService.Model.OrderResponse;
import com.OrderService.OrderService.Service.OrderService;
import com.OrderService.OrderService.Service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest requestBody) {

          var response =  orderService.placeOrder(requestBody);


          return  ResponseEntity.ok(response);

    }

}
