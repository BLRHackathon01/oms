package com.example.oms.dao;

import com.example.oms.dto.CurrentStatus;

public class ConfirmDto {

    private CurrentStatus currentStatus;

    public CurrentStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(CurrentStatus currentStatus) {
        this.currentStatus = currentStatus;
    }
}
