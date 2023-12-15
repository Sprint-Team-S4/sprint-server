package com.keyin.Aircraft.Controller;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Aircraft.Repository.AircraftRepository;
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

//    ;List All Aircrafts - - - -
    @GetMapping("/all")
    public List<Aircraft> getAllAircrafts() {
        return (List<Aircraft>) repo.findAll();
    }

//    ;Add Aircraft - - - -
    @PostMapping("/add")
    public void createAircraft(@RequestBody Aircraft aircraft) {
        repo.save(aircraft);
    }
}

