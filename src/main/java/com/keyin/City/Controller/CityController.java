package com.keyin.City.Controller;

import com.keyin.City.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/city")
public class CityController {

//    ;Repository - - - -
    @Autowired
    private CityRepository repo;
}

