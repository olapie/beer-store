package com.olapie.beerstore.domain.model.exception;

public class BeerNotFoundException extends NotFoundException {
    BeerNotFoundException() {
        super("beer not found");
    }
}
