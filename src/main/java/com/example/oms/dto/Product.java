package com.example.oms.dto;

import jakarta.persistence.Entity;

@Entity
public class Product extends BaseModel{

    private String productName;
    private int quantity;
    private int price;
    private Symbol symbol;
}
