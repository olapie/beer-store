package com.olapie.beerstore.infra.postgres;

import com.olapie.beerstore.domain.model.Order;
import com.olapie.beerstore.domain.model.id.OrderId;
import com.olapie.beerstore.domain.repository.OrderRepository;

import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public Optional<Order> get(OrderId orderId) {
        return Optional.empty();
    }
}
