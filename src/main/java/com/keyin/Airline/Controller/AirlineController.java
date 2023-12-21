package com.keyin.Airline.Controller;

import com.keyin.Airline.Airline;
import com.keyin.Airline.Service.AirlineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/airline")
public class AirlineController {

    private final AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping
    public ResponseEntity<List<Airline>> getAllAirlines() {
        List<Airline> airlines = airlineService.findAllAirlines();
        return ResponseEntity.ok(airlines);
    }

    @PostMapping
    public ResponseEntity<Airline> createAirline(@Valid @RequestBody Airline airline) {
        Airline savedAirline = airlineService.saveAirline(airline);
        return ResponseEntity.ok(savedAirline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable Long id, @Valid @RequestBody Airline airline) {
        Airline updatedAirline = airlineService.updateAirline(id, airline);
        return ResponseEntity.ok(updatedAirline);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable Long id) {
        Airline airline = airlineService.findAirlineById(id)
                .orElseThrow(() -> new RuntimeException("Airline not found for this id :: " + id));
        return ResponseEntity.ok(airline);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable Long id) {
        airlineService.deleteAirline(id);
        return ResponseEntity.noContent().build();
    }

}
