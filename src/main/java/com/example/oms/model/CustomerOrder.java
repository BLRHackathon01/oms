package com.example.oms.model;

import org.springframework.format.annotation.DurationFormat;

import java.util.List;

public class CustomerOrder {
    private String orderId;
    private List<StockItem> stockItems;

}
