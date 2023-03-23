package com.gradprogram.mylibrary.controllers;

import com.gradprogram.mylibrary.NotFoundException;
import com.gradprogram.mylibrary.models.Status;
import com.gradprogram.mylibrary.repositories.StatusRepository;
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
@RequestMapping("/status")
public class StatusController {
    @Autowired
    StatusRepository statusRepository;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<EntityModel<Status>>> all(){
        List<EntityModel<Status>> statuses = statusRepository.findAll().stream()
                .map(status -> EntityModel.of(
                        status,
                        createSelfHateoasLinkGet(status.getStatus_id()),
                        createSelfHateoasLinkAllWithRel())).collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(statuses, createSelfHateoasLinkAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<Status> addNewStatus(@RequestBody Status newStatus){
        return new ResponseEntity<>(statusRepository.save(newStatus), HttpStatus.CREATED);
    }

    @PutMapping("/{statusId}")
    public ResponseEntity<?> changeStatus(@PathVariable Long statusId, @RequestBody Status statusInfo){
        statusInfo.setStatus_id(statusId);
        Status updatedStatus = statusRepository.findById(statusId).orElseThrow(() -> new NotFoundException("Status", statusId)); //TODO returns 500
        updatedStatus.setStatus(statusInfo.getStatus());
        return new ResponseEntity<>(statusRepository.save(updatedStatus),HttpStatus.ACCEPTED);
    }

    @GetMapping("/{statusId}")
    public ResponseEntity<EntityModel<Status>> get(@PathVariable Long statusId){
        Optional<Status> response = statusRepository.findById(statusId);
        if (response.isPresent()){ //TODO refactor to streams otherwise this sucks
            EntityModel<Status> model = EntityModel.of(response.get(), //
                    createSelfHateoasLinkGet(response.get().getStatus_id()), //
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
        return linkTo(methodOn(this.getClass()).all()).withRel("statuses");
    }
}
