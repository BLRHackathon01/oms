package com.example.oms.dto;

import jakarta.persistence.*;

@Entity(name = "OrderTab")
public class Order extends BaseModel{

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    @Enumerated(EnumType.ORDINAL)
    private CurrentStatus status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CurrentStatus getStatus() {
        return status;
    }

    public void setStatus(CurrentStatus status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
