package com.example.customer_data_management.service;

import com.example.customer_data_management.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
