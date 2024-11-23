package com.example.oms.controller;

import com.example.oms.dao.OrderRequestDto;
import com.example.oms.dao.OrderResponseDto;
import com.example.oms.dto.CurrentStatus;
import com.example.oms.dto.Order;
import com.example.oms.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/order")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto){

        Order order = orderService.createOrder(orderRequestDto.getUserId(),
                orderRequestDto.getProductId(),
                orderRequestDto.getQuantity());

        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setOrderId(order.getId());
        responseDto.setStatus(CurrentStatus.PENDING);
        responseDto.setAction("Please confirm on your order.");
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

}
