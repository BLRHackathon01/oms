package com.example.trading.service;

import com.example.trading.kafka.KafkaProducer;
import com.example.trading.model.Order;
import com.example.trading.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaProducer kafkaProducer;

    public Order placeOrder(Order order) {
        if (order.getQuantity() <= 0 || order.getPrice() < 0) {
            throw new IllegalArgumentException("Quantity and Price must be positive.");
        }
        order.setOrderId(UUID.randomUUID());
        Order savedOrder = orderRepository.save(order);

        // Publish to Kafka
        kafkaProducer.sendMessage("stock-events-t1", savedOrder.toString());
        return savedOrder;
    }

    public Optional<Order> getOrderStatus(UUID orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getAllOrders(UUID userId) {
        return orderRepository.findAll();
    }
}
