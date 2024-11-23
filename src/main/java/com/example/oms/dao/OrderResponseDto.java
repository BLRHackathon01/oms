package com.example.oms.dao;

import com.example.oms.dto.CurrentStatus;

public class OrderResponseDto {

    private long orderId;
    private CurrentStatus status;
    private String action;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public CurrentStatus getStatus() {
        return status;
    }

    public void setStatus(CurrentStatus status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
