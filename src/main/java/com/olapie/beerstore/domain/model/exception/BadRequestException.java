package com.olapie.beerstore.domain.model.exception;

public abstract class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}