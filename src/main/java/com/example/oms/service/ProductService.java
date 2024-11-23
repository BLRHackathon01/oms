package com.example.oms.service;

import com.example.oms.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    Product saveProduct(Product product);

    List<Product> findAll();
}
