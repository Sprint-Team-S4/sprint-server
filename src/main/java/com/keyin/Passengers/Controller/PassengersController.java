package com.keyin.Passengers.Controller;

import com.keyin.Passengers.Passengers;
import com.keyin.Passengers.Repository.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/passengers")
public class PassengersController {

//    ;Repository - - - -
    @Autowired
    private PassengersRepository repo;

//    ;List All Passengers - - - -
    @GetMapping("/all")
    public List<Passengers> getAllPassengers() {
        return (List<Passengers>) repo.findAll();
    }

//    Add Passenger - - - -
    @PostMapping("/add")
    public void createPassenger(@RequestBody Passengers passengers) {
        repo.save(passengers);
    }
}
