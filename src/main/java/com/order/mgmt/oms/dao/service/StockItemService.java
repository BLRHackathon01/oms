package com.order.mgmt.oms.dao.service;

import com.order.mgmt.oms.dao.StockItemDAO;
import com.order.mgmt.oms.dao.model.StockItem;
import com.order.mgmt.oms.dao.model.Unit;

import java.util.Arrays;
import java.util.List;

public class StockItemService {
    StockItemDAO stockItemDAO = new StockItemDAO();

    public void addStockItem(StockItem stockItem) {
        List<Unit> units = Arrays.asList(Unit.values());
        try {
            if (stockItem.getItemPrice() < 0)
                throw new Exception("Stock Item Price cannot be negative");
            if (stockItem.getQuantity() < 0)
                throw new Exception("Stock Item Quantity cannot be negative");
            if (!units.contains(stockItem.getUnit()))
                throw new Exception("Stock Item Unit is Invalid");

            stockItemDAO.addStockItem(stockItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStockItem(List<StockItem> stockItems) {
        for (StockItem stockItem : stockItems) {
            stockItemDAO.addStockItem(stockItem);
        }
    }

    public List<StockItem> getAllStockItems() {
        return stockItemDAO.getAllStockItems();
    }
}
