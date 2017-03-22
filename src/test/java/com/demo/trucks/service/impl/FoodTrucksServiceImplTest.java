package com.demo.trucks.service.impl;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by andrei.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.demo.trucks")
public class FoodTrucksServiceImplTest {

    @Autowired
    @InjectMocks
    private FoodTrucksService component;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFoodTrucks() throws Exception {
        FoodTruck[] foodTrucks = {new FoodTruck()};
        ResponseEntity response = new ResponseEntity<>(foodTrucks, HttpStatus.OK);
        when(restTemplate.getForEntity(any(URI.class), any(Class.class))).thenReturn(response);
        List<FoodTruck> result = component.getFoodTrucks(new GeoSquare(37.0, 37.0, -122.0, -122.0));

        assertNotNull(result);
        assertEquals(result.size(), foodTrucks.length);
    }

}