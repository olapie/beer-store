package com.olapie.beerstore.domain.service;

import com.olapie.beerstore.domain.model.Order;
import com.olapie.beerstore.domain.model.id.OrderId;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> get(OrderId orderId);

    List<Order> list(int limit, String nextToken);
}
