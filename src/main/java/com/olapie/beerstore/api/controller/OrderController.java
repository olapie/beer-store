package com.olapie.beerstore.api.controller;

import com.olapie.beerstore.api.model.Order;
import com.olapie.beerstore.domain.model.exception.OrderNotFoundException;
import com.olapie.beerstore.domain.model.id.OrderId;
import com.olapie.beerstore.domain.service.OrderService;
import com.olapie.beerstore.util.annotation.AutoLogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @AutoLogging
    @GetMapping("/{id}")
    public Order get(@PathVariable String id) throws OrderNotFoundException {
        var orderId = OrderId.of(id);
        var optionalOrder = orderService.get(orderId);
        if (optionalOrder.isEmpty()) {
            throw  new OrderNotFoundException(orderId);
        }
        return Order.from(optionalOrder.get());
    }

    @GetMapping("/list")
    public List<Order> list(@RequestParam String nextToken, @RequestParam int limit) {
        return new ArrayList<>();
    }

}
