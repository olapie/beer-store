package com.olapie.beerstore.domain.service.factory;

import com.olapie.beerstore.domain.service.OrderService;
import com.olapie.beerstore.domain.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceFactory {

    @Bean
    public OrderService getOrderService() {
        return new OrderServiceImpl();
    }
}
