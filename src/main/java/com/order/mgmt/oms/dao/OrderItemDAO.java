package com.order.mgmt.oms.dao;

import com.order.mgmt.oms.dao.model.OrderItem;
import com.order.mgmt.oms.dao.util.ConnectionManager;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class OrderItemDAO {
    private static final Logger logger = Logger.getLogger(StockItemDAO.class.getName());
    Connection con = ConnectionManager.getConnection();

    static {
        try {
            File dir = new File("logs/");
            if(!dir.exists())
                dir.mkdirs();
            logger.addHandler(new FileHandler("logs/omsLogOrderItemDAO"));
            logger.setUseParentHandlers(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public int getLastInsertID() {
        int key = -1;
        String qry = "SELECT LAST_INSERT_ID()";
        try (PreparedStatement pstmt = con.prepareStatement(qry);) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                key = rs.getInt(1);
            logger.info("Order Item Primary Key = " + key);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return key;
    }

    public void addOrderItem(OrderItem orderItem) {
        String qry = "INSERT IGNORE INTO `orderitem` (`stock_item_number`, `number_of_items`, `po_number`) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(qry)) {
            pstmt.setInt(1, orderItem.getStockItemNumber());
            pstmt.setInt(2, orderItem.getNumberOfItems());
            pstmt.setInt(3, orderItem.getPoNumber());
            int i = pstmt.executeUpdate();
            System.out.println(i + " records inserted...");
            logger.info("Order Item saved successfully. Order Item details = " + orderItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isOrderPresent(OrderItem orderItem) {
        String qry = "SELECT order_item_number FROM orderitem oi "
                + "INNER JOIN purchaseorder po ON oi.po_number = po.po_number "
                + "WHERE po.is_shipped=0 AND oi.stock_item_number=? AND po.po_number=?";
        try (PreparedStatement pstmt = con.prepareStatement(qry)) {
            pstmt.setInt(1, orderItem.getStockItemNumber());
            pstmt.setInt(2, orderItem.getPoNumber());
            ResultSet rs = pstmt.executeQuery();
            if (!rs.isBeforeFirst())
                return false;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return true;
    }

    public void updateExisitngOrder(OrderItem orderItem) {
        String qry = "UPDATE orderitem SET number_of_items=number_of_items+? "
                + "WHERE stock_item_number=? AND po_number=?";
        try (PreparedStatement pstmt = con.prepareStatement(qry)) {
            pstmt.setInt(1, orderItem.getNumberOfItems());
            pstmt.setInt(2, orderItem.getStockItemNumber());
            pstmt.setInt(3, orderItem.getPoNumber());
            int i = pstmt.executeUpdate();
            System.out.println(i + " records updated...");
            logger.info("Updated the Repeated Order Item Quantity Successfully");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


}
