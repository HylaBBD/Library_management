package com.gradprogram.mylibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradprogram.mylibrary.models.Withdrawal;
import com.gradprogram.mylibrary.repositories.WithdrawalRepository;

@RestController
@RequestMapping("/withdrawal")
public class WithdrawalController {
    
    @Autowired WithdrawalRepository withdrawalRepository;

    @PostMapping("/add")
    public ResponseEntity<Withdrawal> addNewWithdrawal(@RequestBody Withdrawal newWithdrawal){
        //TODO before accepting the withdrawal the status of the books need to be checked to see if the library has them/
        //Must check this from the DB directly not from newWithdrawal since newWithdrawal will be setting them to withdrawn
        return new ResponseEntity<>(withdrawalRepository.save(newWithdrawal),HttpStatus.CREATED);
    }
}
