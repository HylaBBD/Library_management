package com.gradprogram.mylibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradprogram.mylibrary.NotFoundException;
import com.gradprogram.mylibrary.models.Customer;
import com.gradprogram.mylibrary.repositories.CustomerRepository;

@RestController
public class CustomerController {
    
    @Autowired CustomerRepository customerRepository;

    @PostMapping("/customer")
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer newCustomer){
        return new ResponseEntity<Customer>(customerRepository.save(newCustomer), HttpStatus.CREATED);
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<Customer> changeCustomerInformation(@PathVariable Long customerId,@RequestBody Customer customerInfo){
        customerInfo.setCustomer_id(customerId);
        Customer updatedCustomer = customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("Customer", customerId));
        updatedCustomer.setEmail(customerInfo.getEmail());
        updatedCustomer.setFirst_name(customerInfo.getFirst_name());
        updatedCustomer.setLast_name(customerInfo.getLast_name());
        return new ResponseEntity<Customer>(customerRepository.save(updatedCustomer),HttpStatus.ACCEPTED);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> allCustomers(){
        return new ResponseEntity<List<Customer>>(customerRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> customerByCustomerId(@PathVariable Long customerId){
        return new ResponseEntity<Customer>(customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("Customer",customerId)), HttpStatus.OK);
    }
}
