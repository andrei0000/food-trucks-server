package com.demo.trucks.service.impl;

import com.demo.trucks.model.GeoSquare;
import com.demo.trucks.service.GeoCalculationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by andrei.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.demo.trucks")
public class GeoCalculationServiceImplTest {

    @Autowired
    private GeoCalculationService geoCalculationService;

    @Test
    public void calculateSquare() throws Exception {
        Double latitude = 37.0;
        Double longitude = -122.0;
        Double range = 50.0;

        GeoSquare geoSquare = geoCalculationService.calculateSquare(latitude, longitude, range);

        assertNotNull(geoSquare);
        assertEquals(geoSquare.getBottomLatitude(), 36.27, 0.1);
        assertEquals(geoSquare.getTopLatitude(), 37.72, 0.1);
        assertEquals(geoSquare.getLeftLongitude(), -122.90, 0.1);
        assertEquals(geoSquare.getRightLongitude(), -121.09, 0.1);
    }

}