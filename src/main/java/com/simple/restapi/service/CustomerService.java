package com.simple.restapi.service;

import com.simple.restapi.domain.Customer;
import com.simple.restapi.dto.CustomerDto;
import com.simple.restapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto getCustomer(Long id){
        Customer customer = customerRepository.getCustomer(id);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setAddress(customer.getAddress());

        return customerDto;
    }
}
