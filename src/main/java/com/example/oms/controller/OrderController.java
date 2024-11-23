package com.example.oms.controller;


import com.example.oms.domain.Order;
import com.example.oms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/order")
public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order createProduct(@RequestBody Order order) {
        order = orderService.saveOrder(order);
        return order;
    }

    //ResponseEntity<Object>

   /* @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> createProduct(@RequestBody Order order) {
        order = orderService.saveOrder(order);
        return new ResponseEntity<>;
    }*/
    @GetMapping(value = "/list")
    public List<Order> getOrders()
    {
        List<Order> orders = orderService.findAll();
        return orders;
    }

    @GetMapping(value = "/{orderId}")
    public Order getOrder(@PathVariable Long orderId)
    {
        Order order = orderService.getOrderById(orderId);
        return order;
    }

    @PutMapping(value="/confirm/{orderId}")
    public Order confirmOrder(@PathVariable Long orderId){
        Order order = orderService.getOrderById(orderId);
        order = orderService.confirmOrder(order);
        return order;
    }


    @PutMapping(value="/cancel/{orderId}")
    public Order cancelOrder(@PathVariable Long orderId){
        Order order = orderService.getOrderById(orderId);
        order = orderService.cancelOrder(order);
        return order;
    }

}
