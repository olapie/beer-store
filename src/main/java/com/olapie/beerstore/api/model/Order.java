package com.olapie.beerstore.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Order {
    String id;

    public static Order from(com.olapie.beerstore.domain.model.Order o) {
        return new Order(o.getId().getValue());
    }
}
