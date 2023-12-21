package com.keyin.City.Controller;

import com.keyin.City.City;
import com.keyin.City.Service.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "*")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        City city = cityService.getCityById(id)
                .orElseThrow(() -> new RuntimeException("City not found for this id :: " + id));
        return ResponseEntity.ok(city);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@Valid @RequestBody City city) {
        City newCity = cityService.saveCity(city);
        return ResponseEntity.ok(newCity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @Valid @RequestBody City cityDetails) {
        City updatedCity = cityService.updateCity(id, cityDetails);
        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
