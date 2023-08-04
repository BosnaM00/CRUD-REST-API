package com.example.crudrestapi.mapper;

import com.example.crudrestapi.dto.CustomerDto;
import com.example.crudrestapi.model.Customer;

public class CustomerMapper {

    public static CustomerDto mapEntityToDto(Customer customer){
        CustomerDto customerDto = new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
        return customerDto;
    }

    public static Customer mapDtoToEntity(CustomerDto customerDto){
        Customer customer = new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail()
        );
        return customer;
    }

}
