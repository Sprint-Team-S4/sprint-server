package com.keyin.Airport.Controller;

import com.keyin.Airport.Airport;
import com.keyin.Airport.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
public class AirportController {
    @Autowired
    private AirportRepository repo;

    @GetMapping("/airports")
    public List<Airport> getAllAirports() {
        return (List<Airport>) repo.findAll();
    }
}
