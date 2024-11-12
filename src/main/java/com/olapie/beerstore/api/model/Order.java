package com.olapie.beerstore.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Order {
    String id;
    BigDecimal amount;

    public static Order from(com.olapie.beerstore.domain.model.Order o) {
        return new Order(o.getId().getValue(), o.getAmount());
    }
}
