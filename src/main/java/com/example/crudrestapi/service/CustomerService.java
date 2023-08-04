package com.example.crudrestapi.service;

import com.example.crudrestapi.dto.CustomerDto;
import com.example.crudrestapi.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customer);
    CustomerDto getCustomerById(Long id);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteCustomer(Long id);
}
