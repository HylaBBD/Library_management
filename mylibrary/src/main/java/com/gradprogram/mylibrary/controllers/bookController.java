package com.gradprogram.mylibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradprogram.mylibrary.models.Book;
import com.gradprogram.mylibrary.repositories.BookRepository;

@RestController
public class bookController {
    @Autowired BookRepository bookRepository;

    @PostMapping("/book")
    public ResponseEntity<Book> addNewBook(@RequestBody Book newBook){
        return new ResponseEntity<Book>(bookRepository.save(newBook),HttpStatus.CREATED);   
    }
}
