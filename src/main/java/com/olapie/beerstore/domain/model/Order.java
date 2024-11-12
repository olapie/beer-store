package com.olapie.beerstore.domain.model;

import com.olapie.beerstore.domain.model.id.OrderId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Order {
    private OrderId id;
    private BigDecimal amount;
}
