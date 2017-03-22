package com.demo.trucks.service;

import com.demo.trucks.model.FoodTruck;
import com.demo.trucks.model.GeoSquare;

import java.util.List;

/**
 * A service to retrieve information about trucks
 */
public interface FoodTrucksService {

    /**
     * Returns the trucks data retrieved from a remote service
     *
     * @param square a geo square on where to look for trucks
     * @return truck data
     */
    List<FoodTruck> getFoodTrucks(GeoSquare square);

}
