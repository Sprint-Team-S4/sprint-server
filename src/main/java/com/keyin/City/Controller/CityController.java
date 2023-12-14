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
public class CityController {
    @Autowired
    private CityRepository repo;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return (List<City>) repo.findAll();
    }

    @GetMapping("/cities/passenger_search")
    public List<City> getAllCities(@RequestParam String passengerName) {
        return (List<City>) repo.findByPassenger_Name(passengerName);
    }

    @PostMapping("/city")
    public void createCity(@RequestBody City city) {
        repo.save(city);
    }

    @PutMapping("/city/{id}")
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

}
