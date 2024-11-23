package com.order.mgmt.oms.dao.service;

import com.order.mgmt.oms.dao.CustomerDAO;
import com.order.mgmt.oms.dao.model.Customer;
import com.order.mgmt.oms.dao.util.ConnectionManager;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    CustomerDAO custDAO = new CustomerDAO();

    public int addCustomer(Customer customer) {
        int key = 0;
        try {
            custDAO.getCon().setAutoCommit(false);
            custDAO.addCustomer(customer);
            custDAO.getCon().commit();
            key = custDAO.getLastInsertID();
            custDAO.getCon().commit();
            custDAO.getCon().setAutoCommit(true);
        } catch (SQLException e1) {
            try {
                ConnectionManager.getConnection().rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            e1.printStackTrace();
        }
        return key;
    }

    public Customer getCustomer(int customerNo) {
        return custDAO.getCustomerById(customerNo);
    }

    public List<Customer> getAllCustomers() {
        return custDAO.getAllCustomers();
    }

    public List<Integer> getCustomerByMaxPurchaseOrder() {
        return custDAO.getCustomerByMaxPurchaseOrder();
    }
}
