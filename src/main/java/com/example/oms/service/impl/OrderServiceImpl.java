package com.example.oms.service.impl;

import com.example.oms.configuration.kafka.KafkaProducer;
import com.example.oms.dto.CurrentStatus;
import com.example.oms.dto.Order;
import com.example.oms.dto.Product;
import com.example.oms.dto.User;
import com.example.oms.repository.OrderRepository;
import com.example.oms.repository.ProductRepository;
import com.example.oms.repository.UserRepository;
import com.example.oms.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    ProductRepository productRepository;
    UserRepository userRepository;
    KafkaProducer kafkaProducer;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository,
                            UserRepository userRepository,
                            KafkaProducer kafkaProducer) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public Order createOrder(long userId, long productId, int quantity,String buyOrSell) {

        // validate the user;
        Optional<User> byId = userRepository.findById(userId);

        if(byId.isEmpty()){
            throw new RuntimeException("User Selected Does not exist."); // define specific exception
        }

        User user = byId.get();

        Optional<Product> optionId = productRepository.findById(productId);

        if(optionId.isEmpty()){
            throw new RuntimeException("Product Selected Does not exist."); // define specific exception
        }

        Product product = optionId.get();

        // Checking availability of quantity
        if(product.getQuantity() > quantity){
            if(buyOrSell.equals("sell")){
                product.setQuantity(product.getQuantity()-quantity);
            }else{
                product.setQuantity(product.getQuantity()+quantity);
            }


        }

        productRepository.save(product);

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setStatus(CurrentStatus.PENDING);

        kafkaProducer.sendMessage(user.getEmail() + ":" +  order.getStatus() + ":" + "Order Updated" );


        return orderRepository.save(order);
    }
}
