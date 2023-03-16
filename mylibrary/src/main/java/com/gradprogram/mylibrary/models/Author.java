package com.gradprogram.mylibrary.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    private int author_id;
    private String first_name;
    private String last_name;
}
