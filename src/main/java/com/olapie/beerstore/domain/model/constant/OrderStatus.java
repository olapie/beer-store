package com.olapie.beerstore.domain.model.constant;

import java.util.Optional;

public enum OrderStatus {

    PENDING(0), PAYMENT_PENDING(1), PAYMENT_RECEIVED(2), ORDER_CONFIRMED(3), SHIPPED(4),
    COMPLETED(5), CANCELLED(6);
    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Optional<OrderStatus> fromValue(int value) {
        for (OrderStatus status: OrderStatus.values()) {
            if (status.value == value) {
                return Optional.of(status);
            }
        }
        return Optional.empty();
    }
}
