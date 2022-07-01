package com.techelevator.locations.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @RequestMapping(path = "/locations/helloworld", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World!";
    }
}
