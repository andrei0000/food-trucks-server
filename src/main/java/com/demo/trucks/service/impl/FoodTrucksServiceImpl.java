package com.demo.trucks.service.impl;

import com.demo.trucks.model.FoodTruck;
import com.demo.trucks.model.GeoSquare;
import com.demo.trucks.service.FoodTrucksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * A service to retrieve information about trucks
 */
@Service
public class FoodTrucksServiceImpl implements FoodTrucksService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodTrucksServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * URL for a remote service
     */
    @Value("${trucks.service.url}")
    private String serviceUrl;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FoodTruck> getFoodTrucks(GeoSquare square) {
        LOGGER.info("Try to call 'Mobile Food Facility Permit' service...");
        LOGGER.debug("Geo square: " + square.toString());

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(serviceUrl)
                .queryParam("$where", square.buildSquare());

        ResponseEntity<FoodTruck[]> response = restTemplate
                .getForEntity(builder.build().toUri(), FoodTruck[].class);

        LOGGER.info("Data was received.");

        return Arrays.asList(response.getBody());
    }
}
