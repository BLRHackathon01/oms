package com.example.oms.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Buy or Sell
    private String orderType;

    // Active or InActive
    private String status;
}
