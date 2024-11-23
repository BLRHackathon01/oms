package com.example.oms.service;

import com.example.oms.domain.Order;
import com.example.oms.domain.Product;
import com.example.oms.domain.User;
import com.example.oms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Page<Order> getAllOrder(Pageable pageable) {
        Page<Order> list = orderRepository.findAll(pageable);
        return list;
    }

    public Order confirmOrder(Order order) {

        if ("PENDING".equals(order.getOrderStatus())) {
            order.setOrderStatus("Executed");

            Product product = order.getProduct();
            Integer qua = order.getQuantity();
            Integer actCnt = product.getActiveCount();
            if ("BUY".equals(order.getOrderType())) {
                product.setActiveCount(actCnt + qua);
            } else if ("SELL".equals(order.getOrderType())) {
                product.setActiveCount(actCnt - qua);
            }
            else{
                // Throw Exception
                // Create and Handle Custom Exceptions
                throw new RuntimeException("Invalid Order Type");
            }
        }

        return saveOrder(order);
    }

    @Override
    public Order cancelOrder(Order order) {

        if ("PENDING".equals(order.getOrderStatus())) {
            order.setOrderStatus("Cancelled");
        }
        return saveOrder(order);
    }

    @Override
    public Order saveOrder(Order order) {

        try {
            order = orderRepository.save(order);
        }catch (Exception e)
        {//// Create and Handle Custom Exceptions
            throw new RuntimeException(" Product / User not found " +
                    " Contact Support team  ");
        }
        return order;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findAll() {
        List<Order> ors = null;

        if (orderRepository !=null) ors = orderRepository.findAll();
        if(ors==null || ors.size()==0) ors = new ArrayList<>();
        return ors;
    }
}
