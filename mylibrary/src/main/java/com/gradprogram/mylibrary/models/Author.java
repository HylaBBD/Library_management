package com.gradprogram.mylibrary.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long author_id;
    private String first_name;
    private String last_name;
    @OneToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    @JsonIgnore
    private List<Book> books;
    @Override
    public String toString (){
        return first_name + " " + last_name;
    }
}
