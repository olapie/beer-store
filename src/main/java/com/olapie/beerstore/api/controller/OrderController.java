package com.olapie.beerstore.api.controller;

import com.olapie.beerstore.api.model.Order;
import com.olapie.beerstore.domain.model.exception.OrderNotFoundException;
import com.olapie.beerstore.domain.model.id.OrderId;
import com.olapie.beerstore.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public Order get(@PathVariable String id) throws OrderNotFoundException {
        var orderId = OrderId.of(id);
        var optionalOrder = orderService.get(orderId);
        if (optionalOrder.isEmpty()) {
            throw  new OrderNotFoundException(orderId);
        }
        return Order.from(optionalOrder.get());
    }

}
