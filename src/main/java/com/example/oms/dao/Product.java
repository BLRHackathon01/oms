package com.example.oms.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private String id;

    private String name;
    private String category;
    private Long stock;
    private String description;
}
