package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.models.Genre;
import com.gradprogram.mylibrary.repositories.GenreRepository;
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
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreRepository genreRepository;

    @PostMapping("/add")
    @Operation(summary = "Record a new genre")
    public ResponseEntity<Genre> addNewGenre(@RequestBody Genre newGenre){
        return new ResponseEntity<>(genreRepository.save(newGenre), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all genres")
    public  ResponseEntity<CollectionModel<EntityModel<Genre>>> all(){
        List<EntityModel<Genre>> genres = genreRepository.findAll().stream()
                .map(genre -> EntityModel.of(
                        genre,
                        createSelfHateoasLinkGet(genre.getGenre_id()),
                        createSelfHateoasLinkAllWithRel())).collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(genres, createSelfHateoasLinkAll()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a genre by ID")
    public ResponseEntity<?> get(@PathVariable Long id){
        Optional<Genre> response = genreRepository.findById(id);
        if (response.isPresent()){ //TODO refactor to streams otherwise this sucks
            EntityModel<Genre> model = EntityModel.of(response.get(), //
                    createSelfHateoasLinkGet(response.get().getGenre_id()), //
                    createSelfHateoasLinkAllWithRel());
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Genre not found");
        }
    }

    private Link createSelfHateoasLinkGet(Long id){
        return linkTo(methodOn(this.getClass()).get(id)).withSelfRel();
    }

    private Link createSelfHateoasLinkAll(){
        return linkTo(methodOn(this.getClass()).all()).withSelfRel();
    }

    private Link createSelfHateoasLinkAllWithRel(){
        return linkTo(methodOn(this.getClass()).all()).withRel("genres");
    }
}
