package com.gradprogram.mylibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradprogram.mylibrary.models.Customer;
import com.gradprogram.mylibrary.repositories.CustomerRepository;

@RestController
public class CustomerController {
    
    @Autowired CustomerRepository customerRepository;

    @PostMapping("/customer")
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer newCustomer){
        return new ResponseEntity<Customer>(customerRepository.save(newCustomer), HttpStatus.CREATED);
    }
}
