package com.keyin.Airport.Controller;

import com.keyin.Airport.Airport;
import com.keyin.Airport.Service.AirportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = airportService.findAllAirports();
        return ResponseEntity.ok(airports);
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(@Valid @RequestBody Airport airport) {
        Airport savedAirport = airportService.saveAirport(airport);
        return ResponseEntity.ok(savedAirport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @Valid @RequestBody Airport airport) {
        Airport updatedAirport = airportService.updateAirport(id, airport);
        return ResponseEntity.ok(updatedAirport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        Airport airport = airportService.findAirportById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found for this id :: " + id));
        return ResponseEntity.ok(airport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }

}