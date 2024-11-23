package com.example.oms.service.impl;

import com.example.oms.dto.Order;
import com.example.oms.dto.Product;
import com.example.oms.repository.OrderRepository;
import com.example.oms.repository.ProductRepository;
import com.example.oms.repository.UserRepository;
import com.example.oms.service.OrderService;

import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    ProductRepository productRepository;
    UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository,
                            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order createOrder(long userId, long productId, int quantity) {

        // validate the user;



        Optional<Product> optionId = productRepository.findById(productId);

        if(optionId.isEmpty()){
            throw new RuntimeException("Product Selected Does not exist."); // define specific exception
        }

        Product product = optionId.get();

        // Checking availability of quantity
        if(product.getQuantity() > quantity){
            product.setQuantity(product.getQuantity()-quantity);
        }

        productRepository.save(product);

        Order order = new Order();
//        order.setUser(userId);


        orderRepository.save(order);

        return null;
    }
}
