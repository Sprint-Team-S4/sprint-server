package com.keyin.Airport.Controller;

import com.keyin.Airport.Airport;
import com.keyin.Airport.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/airport")
public class AirportController {

//    ;Repository - - - -
    @Autowired
    private AirportRepository repo;

//    ;List All Airports - - - -
    @GetMapping("/all")
    public List<Airport> getAllAirports() {
        return (List<Airport>) repo.findAll();
    }

//    ;Add Airport - - - -
    @PostMapping("/add")
    public void createAirport(@RequestBody Airport airport) {
        repo.save(airport);
    }


}
