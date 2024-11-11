package com.olapie.beerstore.domain.model.id;

public class BeerId extends StringId {

    public BeerId(String value) {
        super(value);
    }

    public static OrderId of(String value) {
        return new OrderId(value);
    }
}
