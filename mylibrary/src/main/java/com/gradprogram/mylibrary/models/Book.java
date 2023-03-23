package com.gradprogram.mylibrary.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    private String isbn;

    @OneToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
//    @JsonIgnore
    private List<Author> authors;
    private String title;

    @OneToMany
    @JoinTable(
            name = "books_genres",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    private Set<Genre> genres;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "status_id")
    private Status status;


}
