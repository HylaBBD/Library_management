package com.gradprogram.mylibrary;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String itemNotFound,Long id){
        super(String.format("%s with id %s does not exist"));
    }
}
