package com.keyin.Airline.Controller;

import com.keyin.Airline.Airline;
import com.keyin.Airline.Repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/airline")
public class AirlineController {

//    ;Repository - - - -
    @Autowired
    private AirlineRepository repo;

//    ;List All Airlines - - - -
    @GetMapping("/all")
    public List<Airline> getAllAirlines() {
        return (List<Airline>) repo.findAll();
    }

//    ;Add Airline - - - -
    @PostMapping("/add")
    public void createAirline(@RequestBody Airline airline) {
        repo.save(airline);
    }
}