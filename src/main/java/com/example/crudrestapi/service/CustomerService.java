package com.example.crudrestapi.service;

import com.example.crudrestapi.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Optional<Customer> getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);
}
