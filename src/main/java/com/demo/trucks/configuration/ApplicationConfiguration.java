package com.demo.trucks.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Created by andrei.
 */
@Configuration
public class ApplicationConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfiguration.class);

    /**
     * Timeout when connecting to a remote service
     */
    @Value("${trucks.service.connectTimeout}")
    private int serviceTimeout;

    @Bean
    public RestTemplate restClient(RestTemplateBuilder restTemplateBuilder) {

        return restTemplateBuilder
                .requestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .setConnectTimeout(serviceTimeout)
                .interceptors(Collections.singletonList((request, body, execution) -> {

                    LOGGER.debug("Request URI: " + request.getURI().toString());
                    return execution.execute(request, body);
                }))
                .build();
    }


}
