package com.ridiculands.rest.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RidiculandsConfiguration {

    // TODO ISRAELW Error creating bean with name 'timedAspect' Caused by: java.lang.ClassNotFoundException: org.aspectj.lang.ProceedingJoinPoint
//    @Bean
//    public TimedAspect timedAspect(MeterRegistry meterRegistry) {
//        return new TimedAspect(meterRegistry);
//    }
}
