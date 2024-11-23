package com.example.oms.controller;

import com.example.oms.dao.Order;
import com.example.oms.model.RestResponse;
import com.example.oms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<RestResponse<Order>> createOrder(@RequestBody Order order) {
        RestResponse<Order> orderResponse = new RestResponse<>();
        Order newOrder = orderService.save(order);
        orderResponse.setData(order);
        orderResponse.setStatus(HttpStatus.CREATED);
        orderResponse.setStatusMessage("Order Created Successfully");
        return ResponseEntity.status(orderResponse.getStatus()).body(orderResponse);
    }
}
