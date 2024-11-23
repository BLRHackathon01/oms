package com.example.oms.service;

import com.example.oms.domain.Product;
import com.example.oms.domain.User;
import com.example.oms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    public ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        product = productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> prs = null;

        if (productRepository !=null) prs = productRepository.findAll();
        if(prs==null || prs.size()==0) prs = new ArrayList<>();
        return prs;
    }
}
