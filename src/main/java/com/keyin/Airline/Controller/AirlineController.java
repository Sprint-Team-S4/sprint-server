package com.keyin.Airline.Controller;

import com.keyin.Airline.Airline;
import com.keyin.Airline.Repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
public class AirlineController {
    @Autowired
    private AirlineRepository repo;

    @GetMapping("/gates")
    public List<Airline> getAllAirlines() {
        return (List<Airline>) repo.findAll();
    }
}