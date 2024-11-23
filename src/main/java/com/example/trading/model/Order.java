package com.example.trading.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Order {
    @Id
    private UUID orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank(message = "Stock symbol cannot be blank")
    private String stockSymbol;

    @NotBlank(message = "Order type cannot be blank")
    private String orderType;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @Min(value = 0, message = "Price must be non-negative")
    private double price;

    private String status = "Pending";
}
