package com.olapie.beerstore.domain.model.id;

public class BeerId extends StringId {

    public BeerId(String value) {
        super(value);
    }

    public static BeerId of(String value) {
        return new BeerId(value);
    }
}
