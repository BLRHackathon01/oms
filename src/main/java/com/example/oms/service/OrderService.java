package com.example.oms.service;

import com.example.oms.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    Page<Order> getAllOrder(Pageable pageable);

    Order  saveOrder(Order order);

    Order getOrderById(Long id);

    List<Order> findAll();

    public Order confirmOrder(Order order);

    public Order cancelOrder(Order order);
};
