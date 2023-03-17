package com.gradprogram.mylibrary.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    private int author_id;
    private String first_name;
    private String last_name;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}