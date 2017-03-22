package com.demo.trucks.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrei.
 */
public class GeoSquareTest {


    @Test
    public void buildSquare() throws Exception {
        Double bottomLatitude = 1.0;
        Double topLatitude = 2.0;
        Double leftLongitude = 3.0;
        Double rightLongitude = 4.0;
        GeoSquare square = new GeoSquare(bottomLatitude, topLatitude, leftLongitude, rightLongitude);

        assertEquals(square.buildSquare(), "latitude > 1.0 AND  latitude < 2.0 AND  longitude > 3.0 AND  longitude < 4.0");
    }

}