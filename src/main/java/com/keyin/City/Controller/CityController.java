package com.keyin.City.Controller;

import com.keyin.City.City;
import com.keyin.City.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/city")
public class CityController {

//    ;Repository - - - -
    @Autowired
    private CityRepository repo;

//    ;List All Cities - - - -
    @GetMapping("/all")
    public List<City> getAllCities() {
        return (List<City>) repo.findAll();
    }

//    ;Add City - - - -
    @PostMapping("/add")
    public void createCity(@RequestBody City city) {
        repo.save(city);
    }

//    ;Change City Name (by id) - - - -
    @PutMapping("/{id}")
    public void updateCity(@PathVariable String id, @RequestBody City city, HttpServletResponse response) {
        Optional<City> returnValue = repo.findById(Long.parseLong(id));
        City cityToUpdate;

        if (returnValue.isPresent()) {
            cityToUpdate = returnValue.get();

            cityToUpdate.setName(city.getName());

            repo.save(cityToUpdate);
        } else {
            try {
                response.sendError(404, "City with id: " + city.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    ;List all Cities by Passenger's Last Name - - - - (not needed, use as reference)
    @GetMapping("/search_by_passenger")
    public List<City> getAllCities(@RequestParam String passengerName) {
        return (List<City>) repo.findByPassenger_Name(passengerName);
    }

}
