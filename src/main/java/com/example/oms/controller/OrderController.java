package com.example.oms.controller;

import com.example.oms.dao.Order;
import com.example.oms.model.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @PostMapping()
    public ResponseEntity<RestResponse<Order>> createOrder(@RequestBody Order order) {
        RestResponse<Order> orderResponse = new RestResponse<>();

        return ResponseEntity.status(orderResponse.getStatus()).body(orderResponse);
    }
}
