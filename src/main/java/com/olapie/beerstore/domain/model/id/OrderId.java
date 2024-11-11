package com.olapie.beerstore.domain.model.id;

public class OrderId extends StringId {

    public OrderId(String value) {
        super(value);
    }

    public static OrderId of(String value) {
        return new OrderId(value);
    }
}
