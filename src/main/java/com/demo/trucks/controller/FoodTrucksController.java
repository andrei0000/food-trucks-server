package com.demo.trucks.controller;

import com.demo.trucks.model.FoodTruck;
import com.demo.trucks.model.GeoSquare;
import com.demo.trucks.service.FoodTrucksService;
import com.demo.trucks.service.GeoCalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andrei.
 */
@RestController
@RequestMapping("/api")
public class FoodTrucksController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodTrucksController.class);

    @Autowired
    private FoodTrucksService foodTrucksService;

    @Autowired
    private GeoCalculationService geoCalculationService;

    /**
     * Returns the trucks data filtered by parameters supplied.
     *
     * @param latitude  latitude of the center
     * @param longitude longitude of the center
     * @param range a distance from the center to the any border of a square
     * @return trucks data
     */
    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    public List<FoodTruck> getFoodTrucks(@RequestParam("latitude") Double latitude,
                                         @RequestParam("longitude") Double longitude,
                                         @RequestParam("range") Double range){

        GeoSquare square = geoCalculationService.calculateSquare(latitude, longitude, range);

        return foodTrucksService.getFoodTrucks(square);
    }

}
