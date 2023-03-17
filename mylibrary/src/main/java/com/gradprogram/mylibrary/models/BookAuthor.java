package com.gradprogram.mylibrary.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "book_authors")
public class BookAuthor {
    @Id
    @GeneratedValue
    private int books_authors_id;
    private int book_id;
    private int author_id;
}
