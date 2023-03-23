package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.NotFoundException;
import com.gradprogram.mylibrary.models.Author;
import com.gradprogram.mylibrary.models.Book;
import com.gradprogram.mylibrary.repositories.AuthorRepository;
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
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<EntityModel<Author>>> all(){
        List<EntityModel<Author>> statuses = authorRepository.findAll().stream()
                .map(status -> EntityModel.of(
                        status,
                        createSelfHateoasLinkGet(status.getAuthor_id()),
                        createSelfHateoasLinkAllWithRel())).collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(statuses, createSelfHateoasLinkAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addNewAuthor(@RequestBody Author newAuthor){
        return new ResponseEntity<>(authorRepository.save(newAuthor), HttpStatus.CREATED);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<?> changeStatus(@PathVariable Long authorId, @RequestBody Author authorInfo){
        authorInfo.setAuthor_id(authorId);
        Author updatedAuthor = authorRepository.findById(authorId).orElseThrow(() -> new NotFoundException("Author", authorId)); //TODO returns 500
        updatedAuthor.setBooks(authorInfo.getBooks());
        updatedAuthor.setFirst_name(authorInfo.getFirst_name());
        updatedAuthor.setLast_name(authorInfo.getLast_name());
        return new ResponseEntity<>(authorRepository.save(updatedAuthor),HttpStatus.ACCEPTED);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<EntityModel<Author>> get(@PathVariable Long authorId){
        Optional<Author> response = authorRepository.findById(authorId);
        if (response.isPresent()){ //TODO refactor to streams otherwise this sucks
            EntityModel<Author> model = EntityModel.of(response.get(), //
                    createSelfHateoasLinkGet(response.get().getAuthor_id()), //
                    createSelfHateoasLinkAllWithRel());
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{authorId}/books")
    public ResponseEntity<CollectionModel<EntityModel<Book>>> getAuthorBooks(@PathVariable Long authorId){
        Optional<Author> response = authorRepository.findById(authorId);
        if (response.isPresent()){ //TODO refactor to streams otherwise this sucks
            List<EntityModel<Book>> books = response.get().getBooks().stream()
                    .map(book -> EntityModel.of(
                            book,
                            createSelfHateoasLinkGet(book.getBook_id()),
                            createSelfHateoasLinkAllWithRel())).collect(Collectors.toList());
            return ResponseEntity.ok(CollectionModel.of(books, createSelfHateoasLinkAll()));
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
        return linkTo(methodOn(this.getClass()).all()).withRel("statuses");
    }
}
