package com.example.crudrestapi.controller;

import com.example.crudrestapi.model.Customer;
import com.example.crudrestapi.service.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer successfully deleted!", HttpStatus.OK);
    }

}
