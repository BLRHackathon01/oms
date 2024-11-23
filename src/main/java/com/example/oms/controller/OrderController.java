package com.example.oms.controller;

import com.example.oms.dao.Order;
import com.example.oms.model.RestResponse;
import com.example.oms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<RestResponse<Order>> createOrder(@RequestBody Order order) {
        RestResponse<Order> orderResponse = new RestResponse<>();
        Order newOrder = orderService.save(order);
        orderResponse.setData(newOrder);
        orderResponse.setStatus(HttpStatus.CREATED);
        orderResponse.setStatusMessage("Order Created Successfully");
        return ResponseEntity.status(orderResponse.getStatus()).body(orderResponse);
    }

    @GetMapping()
    public ResponseEntity<RestResponse<List<Order>>> readAllOrders() {
        RestResponse<List<Order>> orderResponse = new RestResponse<>();
        List<Order> allOrders = orderService.findAll();
        orderResponse.setData(allOrders);
        orderResponse.setStatusMessage("Orders Retrieved Successfully");
        return ResponseEntity.status(orderResponse.getStatus()).body(orderResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<Order>> readOrderById(@PathVariable String id) {
        RestResponse<Order> orderResponse = new RestResponse<>();
        Order order = orderService.findById(id);
        orderResponse.setData(order);
        orderResponse.setStatusMessage("Order Retrieved Successfully");
        return ResponseEntity.status(orderResponse.getStatus()).body(orderResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<Order>> updateOrderById(@PathVariable String id, @RequestBody Order order) {
        RestResponse<Order> orderResponse = new RestResponse<>();
        Order updatedOrder = orderService.updateById(id, order);
        orderResponse.setData(updatedOrder);
        orderResponse.setStatusMessage("Order Updated Successfully");
        return ResponseEntity.status(orderResponse.getStatus()).body(orderResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Order>> deleteOrderById(@PathVariable String id) {
        RestResponse<Order> orderResponse = new RestResponse<>();
        orderService.deleteById(id);
        orderResponse.setData(null);
        orderResponse.setStatusMessage("Order Deleted Successfully");
        return ResponseEntity.status(orderResponse.getStatus()).body(orderResponse);
    }
}
