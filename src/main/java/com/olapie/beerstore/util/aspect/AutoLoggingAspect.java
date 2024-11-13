package com.olapie.beerstore.util.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class AutoLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(AutoLoggingAspect.class);
    @Around("@annotation(com.olapie.beerstore.util.annotation.AutoLogging)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        var start = Instant.now();
        Object returnedValue = joinPoint.proceed();
        var millis = Duration.between(start, Instant.now()).toMillis();

        logger.info("{} time cost: {}ms", joinPoint.getSignature(), millis);

        return returnedValue;
    }
}
