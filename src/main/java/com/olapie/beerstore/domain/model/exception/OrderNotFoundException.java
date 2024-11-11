package com.olapie.beerstore.domain.model.exception;

import com.olapie.beerstore.domain.model.id.OrderId;

public class OrderNotFoundException extends NotFoundException {
    public OrderNotFoundException() {
        super("order not found");
    }

    public OrderNotFoundException(OrderId orderId) {
        super(String.format("order %s not found", orderId));
    }
}
