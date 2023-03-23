package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.models.Status;
import com.gradprogram.mylibrary.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    StatusRepository statusRepository;

    @PostMapping("/add")
    public ResponseEntity<Status> addNewAuthor(@RequestBody Status newStatus){
        return new ResponseEntity<Status>(statusRepository.save(newStatus), HttpStatus.CREATED);
    }
}
