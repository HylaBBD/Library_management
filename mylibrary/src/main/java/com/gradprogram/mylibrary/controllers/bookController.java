package com.gradprogram.mylibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradprogram.mylibrary.models.Book;
import com.gradprogram.mylibrary.repositories.BookRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class bookController {
    @Autowired BookRepository bookRepository;

    @PostMapping("/book")
    @Operation(summary = "Allows you to record a book that is added to a library")
    public ResponseEntity<Book> addNewBook(@RequestBody Book newBook){
        return new ResponseEntity<Book>(bookRepository.save(newBook),HttpStatus.CREATED);   
    }
}
