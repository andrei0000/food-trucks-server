package com.demo.trucks.service.impl;

import com.demo.trucks.model.GeoSquare;
import com.demo.trucks.service.GeoCalculationService;
import org.springframework.stereotype.Service;

/**
 * A service to perform geo square region calculation
 */
@Service
public class GeoCalculationServiceImpl implements GeoCalculationService {

    /**
     * {@inheritDoc}
     */
    @Override
    public GeoSquare calculateSquare(Double latitude, Double longitude, Double range) {
        Double bottomLatitude = latitude - (range / 69);
        Double topLatitude = latitude + (range / 69);

        Double delta = range / Math.abs(Math.cos(Math.toRadians(latitude)) * 69);
        Double leftLongitude = longitude - delta;
        Double rightLongitude = longitude + delta;

        return new GeoSquare(bottomLatitude, topLatitude, leftLongitude, rightLongitude);
    }

}
