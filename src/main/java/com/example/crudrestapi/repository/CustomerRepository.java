package com.example.crudrestapi.repository;

import com.example.crudrestapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//SimpleJpaRepository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
