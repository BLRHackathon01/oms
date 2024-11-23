package com.example.oms.service.impl;

import com.example.oms.dao.Product;
import com.example.oms.repository.ProductRepository;
import com.example.oms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product save(Product entity) {
        return repository.save(entity);
    }

    @Override
    public Product findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product updateById(String id, Product entity) {
        Optional<Product> order = repository.findById(id);
        if (order.isPresent()) {
            repository.save(entity);
        }
        return null;
    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
