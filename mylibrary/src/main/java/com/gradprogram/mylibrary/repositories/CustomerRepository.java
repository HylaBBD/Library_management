package com.gradprogram.mylibrary.repositories;

import com.gradprogram.mylibrary.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}