package com.example.oms.controller;

import com.example.oms.dao.Product;
import com.example.oms.model.RestResponse;
import com.example.oms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<RestResponse<Product>> createProduct(@RequestBody Product product) {
        RestResponse<Product> productResponse = new RestResponse<>();
        Product newProduct = productService.save(product);
        productResponse.setData(newProduct);
        productResponse.setStatus(HttpStatus.CREATED);
        productResponse.setStatusMessage("Product Created Successfully");
        return ResponseEntity.status(productResponse.getStatus()).body(productResponse);
    }

    @GetMapping()
    public ResponseEntity<RestResponse<List<Product>>> readAllProducts() {
        RestResponse<List<Product>> productResponse = new RestResponse<>();
        List<Product> allProducts = productService.findAll();
        productResponse.setData(allProducts);
        productResponse.setStatusMessage("Products Retrieved Successfully");
        return ResponseEntity.status(productResponse.getStatus()).body(productResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<Product>> readProductById(@PathVariable String id) {
        RestResponse<Product> productResponse = new RestResponse<>();
        Product product = productService.findById(id);
        productResponse.setData(product);
        productResponse.setStatusMessage("Product Retrieved Successfully");
        return ResponseEntity.status(productResponse.getStatus()).body(productResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<Product>> updateProductById(@PathVariable String id, @RequestBody Product product) {
        RestResponse<Product> productResponse = new RestResponse<>();
        Product updatedProduct = productService.updateById(id, product);
        productResponse.setData(updatedProduct);
        productResponse.setStatusMessage("Product Updated Successfully");
        return ResponseEntity.status(productResponse.getStatus()).body(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Product>> deleteProductById(@PathVariable String id) {
        RestResponse<Product> productResponse = new RestResponse<>();
        productService.deleteById(id);
        productResponse.setData(null);
        productResponse.setStatusMessage("Product Deleted Successfully");
        return ResponseEntity.status(productResponse.getStatus()).body(productResponse);
    }
}
