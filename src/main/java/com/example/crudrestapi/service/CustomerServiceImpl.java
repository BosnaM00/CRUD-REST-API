package com.example.crudrestapi.service;

import com.example.crudrestapi.dto.CustomerDto;
import com.example.crudrestapi.mapper.CustomerMapper;
import com.example.crudrestapi.model.Customer;
import com.example.crudrestapi.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    private ModelMapper modelMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        //Convert customerDto to customer;
        //Customer newCustomer = CustomerMapper.mapDtoToEntity(customerDto);
        Customer newCustomer = modelMapper.map(customerDto, Customer.class);

        customerRepository.save(newCustomer);

        //Convert newCustomer to customerDto
        //CustomerDto newCustomerDto = CustomerMapper.mapEntityToDto(newCustomer);
        CustomerDto newCustomerDto = modelMapper.map(newCustomer, CustomerDto.class);


        return newCustomerDto;
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer newCustomer = customer.get();
        return modelMapper.map(newCustomer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for(Customer customer: customers){
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customerRepository.save(customer);
        CustomerDto newCustomerDto = modelMapper.map(customer, CustomerDto.class);

        return newCustomerDto;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
