package com.example.product_management.service;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductService {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> findByName(String name);
}
