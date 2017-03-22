package com.demo.trucks.controller;

import com.demo.trucks.model.FoodTruck;
import com.demo.trucks.model.GeoSquare;
import com.demo.trucks.service.FoodTrucksService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by andrei.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.demo.trucks")
public class FoodTrucksControllerTest {

    @Autowired
    @InjectMocks
    private FoodTrucksController component;

    @Mock
    private FoodTrucksService foodTrucksService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFoodTrucks() throws Exception {
        List<FoodTruck> list = new ArrayList<>();
        list.add(new FoodTruck());
        when(foodTrucksService.getFoodTrucks(any(GeoSquare.class))).thenReturn(list);

        List<FoodTruck> result = component.getFoodTrucks(37.0, -122.0, 50.0);
        assertNotNull(result);
        assertEquals(result.size(), list.size());
    }

}