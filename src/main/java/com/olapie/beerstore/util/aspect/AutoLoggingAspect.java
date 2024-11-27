package com.olapie.beerstore.util.aspect;

import com.olapie.beerstore.util.annotation.AutoLogging;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
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
        var args = joinPoint.getArgs();
        var signature = joinPoint.getSignature();

        if (!(signature instanceof MethodSignature)) {
            return returnedValue;
        }

        var methodSignature = (MethodSignature)signature;
        var argNames = methodSignature.getParameterNames();
        var annotation = methodSignature.getMethod().getAnnotation(AutoLogging.class);

        var argStringBuilder = new StringBuilder();
        argStringBuilder.append(signature.getDeclaringTypeName());
        argStringBuilder.append('.');
        argStringBuilder.append(signature.getName());
        argStringBuilder.append('(');
        for (int i = 0; i < args.length; i++) {
            argStringBuilder.append(argNames[i]);
            if (annotation.input()) {
                argStringBuilder.append("=");
                argStringBuilder.append(args[i]);
            }
            if (i != args.length-1) {
                argStringBuilder.append(", ");
            }
        }
        argStringBuilder.append(")");
        if (annotation.output()) {
            argStringBuilder.append(", returned: ");
            argStringBuilder.append(returnedValue);
        }
        logger.info("{} {}ms", argStringBuilder, millis);
        return returnedValue;
    }
}
