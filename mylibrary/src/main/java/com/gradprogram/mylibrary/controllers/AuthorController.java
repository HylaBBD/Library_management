package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.models.Author;
import com.gradprogram.mylibrary.repositories.AuthorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @ResponseBody
    @PostMapping("/author")
    public ResponseEntity<Author> addNewAuthor(@RequestBody Author newAuthor){
        return new ResponseEntity<Author>(authorRepository.save(newAuthor), HttpStatus.CREATED);
    }

    @GetMapping("/authors")
    public String booksList(ModelMap model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "authors-list";
    }

    @GetMapping("/author-add")
    public String addBook(ModelMap model) {
        model.addAttribute("author", new Author());
        return "authors-add";
    }
}
