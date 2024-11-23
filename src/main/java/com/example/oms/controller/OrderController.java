package com.example.oms.controller;

import com.example.oms.dao.OrderRequestDto;
import com.example.oms.dao.OrderResponseDto;
import com.example.oms.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oms")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto){

        orderService.createOrder(orderRequestDto.getUserId(),
                orderRequestDto.getProductId(),
                orderRequestDto.getQuantity());
        return null;
    }

}
