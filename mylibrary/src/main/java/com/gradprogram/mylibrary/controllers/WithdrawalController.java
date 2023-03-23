package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.models.Book;
import com.gradprogram.mylibrary.models.Status;
import com.gradprogram.mylibrary.models.Withdrawal;
import com.gradprogram.mylibrary.repositories.BookRepository;
import com.gradprogram.mylibrary.repositories.WithdrawalRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/withdrawal")
public class WithdrawalController {
    
    @Autowired
    WithdrawalRepository withdrawalRepository;
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/all")
    @Operation(summary = "Record a new withdrawal")
    public ResponseEntity<CollectionModel<EntityModel<Withdrawal>>> all(){
        List<EntityModel<Withdrawal>> withdrawals = withdrawalRepository.findAll().stream()
                .map(withdrawal -> EntityModel.of(
                        withdrawal,
                        createSelfHateoasLinkGet(withdrawal.getWithdrawal_id()),
                        createSelfHateoasLinkAllWithRel())).collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(withdrawals, createSelfHateoasLinkAll()));
    }

    @PostMapping("/add")
    @Operation(summary = "Record a new withdrawal")
    public ResponseEntity<?> addNewWithdrawal(@RequestBody Withdrawal newWithdrawal){
        List<Long> booksToBeWithdrawn = newWithdrawal.getBooks().stream().map(Book::getBook_id).collect(Collectors.toList());
        List<Long> availableBooks = bookRepository.findAll().stream()
                .filter(book -> book.getStatus().getStatus_id() == 1)
                .map(Book::getBook_id)
                .toList();
        boolean present = true;
        for(Long i : booksToBeWithdrawn){
            present &= availableBooks.contains(i);
        }
        if (present) {
            List<Book> books = bookRepository.findAllById(booksToBeWithdrawn);
            books.forEach(book -> book.setStatus(new Status(2L)));
            newWithdrawal.setBooks(books);
            return new ResponseEntity<>(withdrawalRepository.save(newWithdrawal), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Not all books are available", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/return")
    @Operation(summary = "Return books and end a withdrawal")
    public ResponseEntity<String> returnBooks(@RequestBody Withdrawal oldWithdrawal) {
        List<Long> booksToBeReturned = oldWithdrawal.getBooks().stream().map(Book::getBook_id).collect(Collectors.toList());
        List<Book> books = bookRepository.findAllById(booksToBeReturned);
        books.forEach(book -> book.setStatus(new Status(1L)));
        withdrawalRepository.deleteById(oldWithdrawal.getWithdrawal_id());
        return ResponseEntity.ok("Returned books and deleted withdrawal record");
    }


    @GetMapping("/{withdrawalId}")
    @Operation(summary = "Get a withdrawal by ID")
    public ResponseEntity<EntityModel<Withdrawal>> get(@PathVariable Long withdrawalId){
        Optional<Withdrawal> response = withdrawalRepository.findById(withdrawalId);
        if (response.isPresent()){ //TODO refactor to streams otherwise this sucks
            EntityModel<Withdrawal> model = EntityModel.of(response.get(), //
                    createSelfHateoasLinkGet(response.get().getWithdrawal_id()), //
                    createSelfHateoasLinkAllWithRel());
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private Link createSelfHateoasLinkGet(Long id){
        return linkTo(methodOn(this.getClass()).get(id)).withSelfRel();
    }

    private Link createSelfHateoasLinkAll(){
        return linkTo(methodOn(this.getClass()).all()).withSelfRel();
    }

    private Link createSelfHateoasLinkAllWithRel(){
        return linkTo(methodOn(this.getClass()).all()).withRel("withdrawals");
    }
}
