package com.olapie.beerstore.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddBeerRequest {
    @NotBlank(message = "missing beer name")
    @Size(max = 32)
    private String name;

    private BigDecimal price;
}
