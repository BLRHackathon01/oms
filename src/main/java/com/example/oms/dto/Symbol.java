package com.example.oms.dto;

import jakarta.persistence.Entity;

@Entity
public class Symbol extends BaseModel{

    private String productSymbol;

    public String getProductSymbol() {
        return productSymbol;
    }

    public void setProductSymbol(String productSymbol) {
        this.productSymbol = productSymbol;
    }
}
