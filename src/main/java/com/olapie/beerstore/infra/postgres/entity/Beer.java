package com.olapie.beerstore.infra.postgres.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
public class Beer {
    private String id;
    private String name;
    private BigDecimal price;
}
