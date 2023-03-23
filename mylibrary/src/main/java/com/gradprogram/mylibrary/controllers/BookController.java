package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.gradprogram.mylibrary.models.Book;
import com.gradprogram.mylibrary.repositories.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<EntityModel<Book>>> all() {
        List<EntityModel<Book>> books = bookRepository.findAll().stream()
                .map(book -> EntityModel.of(
                        book,
                        createSelfHateoasLinkGet(book.getBook_id()),
                        createSelfHateoasLinkAllWithRel())).collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(books, createSelfHateoasLinkAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addNewBook(@RequestBody Book newBook) {
        return new ResponseEntity<>(bookRepository.save(newBook), HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<EntityModel<Book>> get(@PathVariable Long customerId) {
        Optional<Book> response = bookRepository.findById(customerId);
        if (response.isPresent()) { //TODO refactor to streams otherwise this sucks
            EntityModel<Book> model = EntityModel.of(response.get(), //
                    createSelfHateoasLinkGet(response.get().getBook_id()), //
                    createSelfHateoasLinkAllWithRel());
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> changeBookInformation(@PathVariable Long bookId, @RequestBody Book bookInfo) {
        bookInfo.setBook_id(bookId);
        Book updatedBook = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Book", bookId));
        updatedBook.setAuthors(bookInfo.getAuthors());
        updatedBook.setIsbn(bookInfo.getIsbn());
        updatedBook.setTitle(bookInfo.getTitle());
        updatedBook.setStatus(bookInfo.getStatus());
        updatedBook.setGenres(bookInfo.getGenres());
        return new ResponseEntity<>(bookRepository.saveAndFlush(updatedBook), HttpStatus.ACCEPTED);
    }

    private Link createSelfHateoasLinkGet(Long id) {
        return linkTo(methodOn(this.getClass()).get(id)).withSelfRel();
    }

    private Link createSelfHateoasLinkAll() {
        return linkTo(methodOn(this.getClass()).all()).withSelfRel();
    }

    private Link createSelfHateoasLinkAllWithRel() {
        return linkTo(methodOn(this.getClass()).all()).withRel("books");
    }
}
