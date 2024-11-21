package com.gerasimchuk.maksim.qrforfun.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@RequiredArgsConstructor
public class SelfPingService {

    private final RestTemplate restTemplate;

    private static final String URI = "https://qrforfun-5ttvwvhh.b4a.run/api/v1/link/hhkjhvfsvdveuygvusyvefyusl";

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    public void ping() {
        log.debug("Ping url");
        var start = System.currentTimeMillis();
        restTemplate.getForObject(URI, String.class);
        var end = System.currentTimeMillis();
        log.debug("Ping successful: " + (end - start) + " millis");
    }
}
