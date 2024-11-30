package com.olapie.beerstore.domain.model.params;

import com.olapie.beerstore.domain.model.id.BeerId;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class AddBeerParams {
    private String name;
    private BigDecimal price;
}
