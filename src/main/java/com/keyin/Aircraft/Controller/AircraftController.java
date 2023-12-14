package com.keyin.Aircraft.Controller;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Aircraft.Repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftRepository repo;

    @GetMapping("/gates")
    public List<Aircraft> getAllAircrafts() {
        return (List<Aircraft>) repo.findAll();
    }
}

