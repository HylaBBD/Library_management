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
@Entity(name = "genres")
public class Genre {
    @Id
    @GeneratedValue
    private int genre_id;
    private String genre_name;
}
