package com.civil.userlocation.controller;

import com.civil.userlocation.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LocationController {

    LocationService locationService;

    /**
     * for example: http://localhost:8080/usersinsidedistane/London
     * @param locationService
     */
    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(value ="/usersinsidedistane/{cityName}")
    public ResponseEntity<?> getUsersWithinDistanceOfCity (@PathVariable("cityName") String cityName) {
        return locationService.getUsersWithinDistanceOfCity(cityName);
    }

}
