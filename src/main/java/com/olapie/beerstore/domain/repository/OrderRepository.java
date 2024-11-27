package com.olapie.beerstore.domain.repository;

import com.olapie.beerstore.domain.model.Order;
import com.olapie.beerstore.domain.model.id.OrderId;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> get(OrderId orderId);

    List<Order> list(String nextToken, int limit);
}
