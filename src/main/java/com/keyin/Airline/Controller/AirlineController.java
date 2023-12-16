package com.keyin.Airline.Controller;

import com.keyin.Airline.Airline;
import com.keyin.Airline.Repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/airline")
public class AirlineController {

//    ;Repository - - - -
    @Autowired
    private AirlineRepository repo;
}