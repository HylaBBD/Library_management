package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.models.Author;
import com.gradprogram.mylibrary.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @PostMapping("/author")
    public ResponseEntity<Author> addNewAuthor(@RequestBody Author newAuthor){
        return new ResponseEntity<Author>(authorRepository.save(newAuthor), HttpStatus.CREATED);
    }
}
