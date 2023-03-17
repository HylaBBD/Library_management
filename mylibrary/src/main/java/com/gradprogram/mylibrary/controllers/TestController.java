package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.models.Author;
import com.gradprogram.mylibrary.models.Book;
import com.gradprogram.mylibrary.repositories.AuthorRepository;
import com.gradprogram.mylibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    //localhost:8080/test will call this endpoint
    @GetMapping("/test")
    public ResponseEntity<?> test(){
        Book book = bookRepository.findById(9L).get();
        List<Author> authors = book.getAuthors();
        Author author = authorRepository.getById(5L);
        List<Book> authorsBooks = author.getBooks();
        return ResponseEntity.ok(authors);
    }
}
