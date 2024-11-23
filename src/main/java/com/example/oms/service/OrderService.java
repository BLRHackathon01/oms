package com.example.oms.service;

import com.example.oms.dto.Order;

public interface OrderService {

    Order createOrder(long userId,long productId,int quantity,String buyOrSell);
}
