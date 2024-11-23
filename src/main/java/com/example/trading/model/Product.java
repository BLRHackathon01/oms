package com.example.trading.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private String stockSymbol;
    private String name;
    private double price;
}
