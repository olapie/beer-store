package com.olapie.beerstore.api.controller;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.olapie.beerstore.domain.model.id.BeerId;
import com.olapie.beerstore.domain.repository.BeerRepository;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class HealthCheckController {
    Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    @Value("${spring.application.name}")
    private String applicationName;
    @Autowired
    private BeerRepository beerRepository;
    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    private static class PingResponse {
        private String applicationName;
        private long currentTimeMillis;
    }

    @GetMapping("ping")
    public PingResponse ping() {
        logger.info("Received ping request");
        long currentTimeMillis = Instant.now().toEpochMilli();
        PingResponse response = new PingResponse();
        response.setCurrentTimeMillis(currentTimeMillis);
        response.setApplicationName(applicationName);
        return response;
    }

    @GetMapping("deep-ping")
    public PingResponse deepPing() {
        logger.info("Received deep ping request");
        beerRepository.get(BeerId.of("0"));
        long currentTimeMillis = Instant.now().toEpochMilli();
        PingResponse response = new PingResponse();
        response.setCurrentTimeMillis(currentTimeMillis);
        response.setApplicationName(applicationName);
        return response;
    }
}