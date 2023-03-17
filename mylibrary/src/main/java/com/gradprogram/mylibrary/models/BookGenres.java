package com.gradprogram.mylibrary.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "book_genres")
public class BookGenres {
    @Id
    @GeneratedValue
    private int books_genres_id;
    private int book_id;
    private int genre_id;
}
