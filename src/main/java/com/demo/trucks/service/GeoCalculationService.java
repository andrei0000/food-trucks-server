package com.demo.trucks.service;

import com.demo.trucks.model.GeoSquare;

/**
 * A service to perform geo square region calculation
 */
public interface GeoCalculationService {

    /**
     * Returns the coordinates of the square region with the center defined by {@code latitude}
     * and {@code longitude} and the {@code range} (a distance from the center to the any border of a square).
     *
     * @param latitude  latitude of the center
     * @param longitude longitude of the center
     * @param range a distance from the center to the any border of a square
     * @return coordinates of the square region
     */
    GeoSquare calculateSquare(Double latitude, Double longitude, Double range);

}
