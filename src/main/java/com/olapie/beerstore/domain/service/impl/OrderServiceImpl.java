package com.olapie.beerstore.domain.service.impl;

import com.olapie.beerstore.domain.model.Order;
import com.olapie.beerstore.domain.model.id.OrderId;
import com.olapie.beerstore.domain.repository.OrderRepository;
import com.olapie.beerstore.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class OrderServiceImpl implements OrderService {

    private final AtomicLong idCounter = new AtomicLong();
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Optional<Order> get(OrderId orderId) {
        return orderRepository.get(orderId);
    }

    @Override
    public List<Order> list(String nextToken, int limit) {
        return orderRepository.list(nextToken, limit);
    }
}
