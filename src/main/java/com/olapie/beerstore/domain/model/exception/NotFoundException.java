package com.olapie.beerstore.domain.model.exception;

public abstract class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}
