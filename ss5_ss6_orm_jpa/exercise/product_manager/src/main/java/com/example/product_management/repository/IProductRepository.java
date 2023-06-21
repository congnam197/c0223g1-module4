package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository {
    List<Product> findAll();

    void add(Product product);

    Product findById(Integer id);

    void update(Integer id, Product product);

    void remove(Integer id);

    List<Product> findByName(String name);

    boolean checkId(Integer id);
}
