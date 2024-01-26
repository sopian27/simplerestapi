package com.simple.restapi.repository;


import com.simple.restapi.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRepository {

    public Customer getCustomer(Long id){

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("john doe");
        customer.setPhone("0812");
        customer.setAddress("boston");

        return customer;
    }
}
