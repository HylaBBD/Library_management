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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class CustomerController {
    
    @Autowired CustomerRepository customerRepository;

    @PostMapping("/customer")
    @Operation(summary = "Record a new customer")
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer newCustomer){
        return new ResponseEntity<Customer>(customerRepository.save(newCustomer), HttpStatus.CREATED);
    }

    @PutMapping("/customer/{customerId}")
    @Operation(summary = "Alter customer information")
    public ResponseEntity<Customer> changeCustomerInformation(@PathVariable Long customerId,@RequestBody Customer customerInfo){
        customerInfo.setCustomer_id(customerId);
        Customer updatedCustomer = customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("Customer", customerId));
        updatedCustomer.setEmail(customerInfo.getEmail());
        updatedCustomer.setFirst_name(customerInfo.getFirst_name());
        updatedCustomer.setLast_name(customerInfo.getLast_name());
        return new ResponseEntity<Customer>(customerRepository.save(updatedCustomer),HttpStatus.ACCEPTED);
    }

    @GetMapping("/customer")
    @Operation(summary = "Retrieve a list of all customers")
    public ResponseEntity<List<Customer>> allCustomers(){
        return new ResponseEntity<List<Customer>>(customerRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Retrieve a customer by their customer Id")
    public ResponseEntity<Customer> customerByCustomerId(@Parameter(description = "The customer Id of the customer whose information is being updated")@PathVariable Long customerId){
        return new ResponseEntity<Customer>(customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("Customer",customerId)), HttpStatus.OK);
    }
}
