package com.keyin.Aircraft.Controller;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Aircraft.Repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/aircraft")
public class AircraftController {

//    ;Repository - - - -
    @Autowired
    private AircraftRepository repo;
}

