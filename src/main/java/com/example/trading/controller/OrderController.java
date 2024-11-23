package com.example.trading.controller;

import com.example.trading.model.Order;
import com.example.trading.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@Valid @RequestBody Order order) {
        try {
            return ResponseEntity.ok(orderService.placeOrder(order));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{orderId}/status")
    public ResponseEntity<?> getOrderStatus(@PathVariable UUID orderId) {
        return orderService.getOrderStatus(orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam UUID userId) {
        return ResponseEntity.ok(orderService.getAllOrders(userId));
    }
}
