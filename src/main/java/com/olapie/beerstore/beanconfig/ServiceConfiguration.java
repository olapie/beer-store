package com.olapie.beerstore.beanconfig;

import com.olapie.beerstore.domain.service.OrderService;
import com.olapie.beerstore.domain.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    public OrderService getOrderService() {
        return new OrderServiceImpl();
    }
}
