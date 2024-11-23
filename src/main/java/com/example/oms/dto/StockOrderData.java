package com.example.oms.dto;

public class StockOrderData {
    private String stockSymbol;
    private double stockPrice;
    private double fulfilmentrate;
    private String status;

    public String getStockSymbol(){
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public double getFulfilmentrate() {
        return fulfilmentrate;
    }

    public void setFulfilmentrate(double fulfilmentrate) {
        this.fulfilmentrate = fulfilmentrate;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
