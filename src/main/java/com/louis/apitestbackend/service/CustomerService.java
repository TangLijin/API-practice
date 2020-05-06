package com.louis.apitestbackend.service;

import com.louis.apitestbackend.dao.CustomerRepository;
import com.louis.apitestbackend.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findCustomerByName(String name){
        return customerRepository.findByName(name);
    }
    public Customer findCustomerById(Long Id) {
        return customerRepository.findCustomerById(Id);
    }

    public List<String> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }
}
