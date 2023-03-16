package com.gradprogram.mylibrary.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private int customer_id;
    private String first_name;
    private String last_name;
    private String email;
}
