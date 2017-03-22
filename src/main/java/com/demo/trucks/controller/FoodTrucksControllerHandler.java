package com.demo.trucks.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrei.
 */
@ControllerAdvice(assignableTypes = FoodTrucksController.class)
public class FoodTrucksControllerHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodTrucksControllerHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public void handleIllegalStateException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
