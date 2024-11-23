package com.order.mgmt.oms.dao.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerNo;
    private String name;
    private String homePhone;
    private String cellPhone;
    private String workPhone;
    private String street;
    private String city;
    private String state;
    private String zip;




    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Customer(String name, String homePhone, String cellPhone, String workPhone, String street, String city,
                    String state, String zip) {
        super();
        // this.customerNo = customerNo;
        this.name = name;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.workPhone = workPhone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Customer [customerNo=" + customerNo + ", name=" + name + ", homePhone=" + homePhone + ", cellPhone="
                + cellPhone + ", workPhone=" + workPhone + ", street=" + street + ", city=" + city + ", state=" + state
                + ", zip=" + zip + "]";
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



}
