package com.olapie.beerstore.domain.repository;

import com.olapie.beerstore.domain.model.Order;
import com.olapie.beerstore.domain.model.id.OrderId;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> get(OrderId orderId);
}
