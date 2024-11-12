package com.olapie.beerstore.domain.model;

import com.olapie.beerstore.domain.model.id.BeerId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Beer {
    private BeerId id;
    private String name;
    private BigDecimal price;
}
