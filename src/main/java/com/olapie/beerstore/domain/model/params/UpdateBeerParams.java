package com.olapie.beerstore.domain.model.params;

import com.olapie.beerstore.domain.model.id.BeerId;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class UpdateBeerParams {
    private BeerId id;
    private String name;
    private BigDecimal price;
}
