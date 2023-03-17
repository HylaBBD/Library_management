package com.gradprogram.mylibrary.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private Long customer_id;
    private String first_name;
    private String last_name;
    private String email;
}
