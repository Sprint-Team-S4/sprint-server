package com.keyin.Passengers.Controller;

import com.keyin.Passengers.Passengers;
import com.keyin.Passengers.Repository.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/passengers")
public class PassengersController {

//    ;Repository - - - -
    @Autowired
    private PassengersRepository repo;
}
