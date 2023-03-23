package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.models.Genre;
import com.gradprogram.mylibrary.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {
    @Autowired
    GenreRepository genreRepository;

    @PostMapping("/genre")
    public ResponseEntity<Genre> addNewGenre(@RequestBody Genre newGenre){
        return new ResponseEntity<Genre>(genreRepository.save(newGenre), HttpStatus.CREATED);
    }
}
