package com.olapie.beerstore.beanconfig;


import com.olapie.beerstore.domain.repository.BeerRepository;
import com.olapie.beerstore.domain.repository.OrderRepository;
import com.olapie.beerstore.infra.postgres.BeerRepositoryImpl;
import com.olapie.beerstore.infra.postgres.OrderRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    BeerRepository getBeerRepository() {
        return new BeerRepositoryImpl();
    }

    @Bean
    OrderRepository getOrderRepository() {
        return new OrderRepositoryImpl();
    }
}
