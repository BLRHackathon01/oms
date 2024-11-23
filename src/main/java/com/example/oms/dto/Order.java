package com.example.oms.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Order extends BaseModel{

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;


    private CurrentStatus status;
}
