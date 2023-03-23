package com.gradprogram.mylibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradprogram.mylibrary.models.Withdrawal;
import com.gradprogram.mylibrary.repositories.WithdrawalRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class WithrawalController {
    
    @Autowired WithdrawalRepository withdrawalRepository;

    @PostMapping("/withdrawal")
    @Operation(summary = "Allows you to log a new withdrawal")
    public ResponseEntity<Withdrawal> addNewWithdrawal(@RequestBody Withdrawal newWithdrawal){
        return new ResponseEntity<Withdrawal>(withdrawalRepository.save(newWithdrawal),HttpStatus.CREATED);
    }
}
