package com.example.customer_data_management.repository;

import com.example.customer_data_management.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
