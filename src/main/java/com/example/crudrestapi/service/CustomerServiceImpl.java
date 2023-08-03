package com.example.crudrestapi.service;

import com.example.crudrestapi.model.Customer;
import com.example.crudrestapi.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    /*
    Well, typically we need to use @Autowired annotation to inject the dependency, isn't it?
    But spring 4.3 onwards, whenever there is a spring bean, it has a single parameterized constructor then we can omit using
    @Autowired annotation.
    Well, notice here we have a UserServiceImpl as a spring bean, and this Spring bean has only one parameterized constructor.
    Hence we don't have to use @Autowired annotation to inject this dependency
     */
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
