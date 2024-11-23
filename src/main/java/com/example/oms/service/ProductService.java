package com.example.oms.service;

import com.example.oms.dao.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService extends ICRUDService<Product, String> {
}
