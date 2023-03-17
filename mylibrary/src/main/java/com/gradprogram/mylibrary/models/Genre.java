package com.gradprogram.mylibrary.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "genres")
public class Genre {
    @Id
    @GeneratedValue
    private Long genre_id;
    private String genre_name;
}
