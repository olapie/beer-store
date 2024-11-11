package com.olapie.beerstore.domain.service.impl;

import com.olapie.beerstore.domain.model.Order;
import com.olapie.beerstore.domain.model.id.OrderId;
import com.olapie.beerstore.domain.service.OrderService;

import java.util.Objects;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    @Override
    public Optional<Order> get(OrderId orderId) {
        if (Objects.equals(orderId.getValue(), "0")) {
            return Optional.empty();
        }
        return Optional.of(new Order(orderId));
    }
}
