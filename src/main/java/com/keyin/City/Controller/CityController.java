package com.keyin.City.Controller;

import com.keyin.City.City;
import com.keyin.City.Repository.CityRepository;
import com.keyin.Flight.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/city")
public class CityController {

//    ;Repository - - - -
    @Autowired
    private CityRepository repo;

//    ;Get City by Airport - - - -
    @GetMapping("/search_by_airport")
    public City getCityByAirport(@RequestParam String airportName) {
        return (City) repo.findByAirport(airportName);
    }
}
