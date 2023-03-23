package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.NotFoundException;
import com.gradprogram.mylibrary.models.Customer;
import com.gradprogram.mylibrary.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class CustomerController {
    
    @Autowired CustomerRepository customerRepository;

    @PostMapping("/add")
    @Operation(summary = "Record a new customer")
    public ResponseEntity<Customer> add(@RequestBody Customer newCustomer){
        return new ResponseEntity<Customer>(customerRepository.save(newCustomer), HttpStatus.CREATED);
    }

    @Operation(summary = "Alter customer information")
    @PutMapping("/{customerId}")
    public ResponseEntity<?> changeCustomerInformation(@PathVariable Long customerId,@RequestBody Customer customerInfo){
            customerInfo.setCustomer_id(customerId);
            Customer updatedCustomer = customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("Customer", customerId));
            updatedCustomer.setEmail(customerInfo.getEmail());
            updatedCustomer.setFirst_name(customerInfo.getFirst_name());
            updatedCustomer.setLast_name(customerInfo.getLast_name());
            return new ResponseEntity<>(customerRepository.save(updatedCustomer),HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    @Operation(summary = "Retrieve a list of all customers")
    public ResponseEntity<CollectionModel<EntityModel<Customer>>> all(){
        List<EntityModel<Customer>> customers = customerRepository.findAll().stream()
                .map(customer -> EntityModel.of(
                        customer,
                        createSelfHateoasLinkGet(customer.getCustomer_id()),
                        createSelfHateoasLinkAllWithRel())).collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(customers, createSelfHateoasLinkAll()));
    }

    @GetMapping("/{customerId}")
    @Operation(summary = "Retrieve a customer by their customer Id")
    public ResponseEntity<EntityModel<Customer>> get(@PathVariable Long customerId){
        Optional<Customer> response = customerRepository.findById(customerId);
        if (response.isPresent()){ //TODO refactor to streams otherwise this sucks
            EntityModel<Customer> model = EntityModel.of(response.get(), //
                    createSelfHateoasLinkGet(response.get().getCustomer_id()), //
                    createSelfHateoasLinkAllWithRel());
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private Link createSelfHateoasLinkGet(Long id){
        return linkTo(methodOn(this.getClass()).get(id)).withSelfRel();
    }

    private Link createSelfHateoasLinkAll(){
        return linkTo(methodOn(this.getClass()).all()).withSelfRel();
    }

    private Link createSelfHateoasLinkAllWithRel(){
        return linkTo(methodOn(this.getClass()).all()).withRel("customers");
    }
}
