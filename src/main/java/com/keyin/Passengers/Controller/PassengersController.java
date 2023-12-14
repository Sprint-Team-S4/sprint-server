package com.keyin.Passengers.Controller;

import com.keyin.Passengers.Passengers;
import com.keyin.Passengers.Repository.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/passengers")
public class PassengersController {
    @Autowired
    private PassengersRepository repo;

    @GetMapping("/allpassengers")
    public List<Passengers> getAllPassengers() {
        return (List<Passengers>) repo.findAll();
    }
}
