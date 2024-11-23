package util;

import java.sql.Connection;

import com.example.oms.src.main.java.com.example.oms.util.ConnectionManager;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        Connection connection = null;
        ConnectionManager ConnectionManager = null;
        try {
            connection = com.example.oms.src.main.java.com.example.oms.util.ConnectionManager.getConnection();
            if (connection != null) {
                System.out.println("Connection established successfully!");
            } else {
                System.out.println("Failed to establish connection!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                    com.example.oms.src.main.java.com.example.oms.util.ConnectionManager.CloseConnection();
            }
        }
    }
}
