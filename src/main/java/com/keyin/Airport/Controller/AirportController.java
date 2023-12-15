package com.keyin.Airport.Controller;

import com.keyin.Airport.Airport;
import com.keyin.Airport.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/airport")
public class AirportController {

//    ;Repository - - - -
    @Autowired
    private AirportRepository repo;
}
