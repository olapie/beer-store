package com.olapie.beerstore.infra.postgres;

import com.olapie.beerstore.domain.model.Order;
import com.olapie.beerstore.domain.model.id.OrderId;
import com.olapie.beerstore.domain.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public Optional<Order> get(OrderId orderId) {
        if (orderId.getValue().compareTo("1") < 0) {
            return Optional.empty();
        }
        return Optional.of(new Order(orderId, BigDecimal.valueOf(10.98)));
    }

    @Override
    public List<Order> list(String nextToken, int limit) {
        return null;
    }
}
