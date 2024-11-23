package com.example.oms.controller;

import com.example.oms.domain.Product;
import com.example.oms.domain.User;
import com.example.oms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product createProduct(@RequestBody Product pr) {
       pr = productService.saveProduct(pr);
        return pr;
    }

    @GetMapping(value = "/list")
    public List<Product> getProducts()
    {
        List<Product> products = productService.findAll();
        return products;
    }

}
