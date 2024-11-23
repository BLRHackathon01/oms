package com.example.oms.controller;

import com.example.oms.model.CustomerOrder;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

@MessageMapping("/order")
    @SendTo("/topics/orders")
    public CustomerOrder processOrder(CustomerOrder customerOrder){
    System.out.println("Recieved Order:" +customerOrder);
    return  customerOrder;
}
}
