package com.olapie.beerstore.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Beer {
    private String id;
    private String name;

    private BigDecimal price;

    public static Beer from(com.olapie.beerstore.domain.model.Beer beer) {
        return Beer.builder()
                .id(beer.getId().getValue())
                .name(beer.getName())
                .price(beer.getPrice())
                .build();
    }
}
