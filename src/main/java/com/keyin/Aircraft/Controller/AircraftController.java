package com.keyin.Aircraft.Controller;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Aircraft.Repository.AircraftRepository;
import com.keyin.Airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/aircraft")
public class AircraftController {

    //    ;Repository - - - -
    @Autowired
    private AircraftRepository repo;

    //    ;Get Airports by Aircraft - - - -
    @GetMapping("/{id}/airports")
    public List<Airport> getAirportsByAircraft(@PathVariable Long aircraftId) {
        Aircraft aircraft = repo.findById(aircraftId).orElse(null);

        if (aircraft != null) {
            return aircraft.getAirports();
        } else {
            return List.of();
        }
    }
}

