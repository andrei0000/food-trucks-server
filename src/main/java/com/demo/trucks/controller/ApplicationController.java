package com.demo.trucks.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String application() {
        return "Application is started";
    }

}
