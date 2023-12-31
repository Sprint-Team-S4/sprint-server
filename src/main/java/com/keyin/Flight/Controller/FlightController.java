package com.keyin.Flight.Controller;

import com.keyin.Flight.Flight;
import com.keyin.Flight.Service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "*")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found for this id :: " + id));
        return ResponseEntity.ok(flight);
    }

    @PostMapping("/create")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight createdFlight = flightService.createFlight(flight);
        return ResponseEntity.ok(createdFlight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @Valid @RequestBody Flight flightDetails) {
        Flight updatedFlight = flightService.updateFlight(id, flightDetails);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    // ;Find all arriving flights by Airport
    @GetMapping("/arriving/{airportCode}")
    public ResponseEntity<List<Flight>> getArrivingFlightsByAirport(@PathVariable String airportCode) {
        List<Flight> flights = flightService.findArrivingFlightsByAirport(airportCode);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/departing/{airportCode}")
    public ResponseEntity<List<Flight>> getDepartingFlightsByAirport(@PathVariable String airportCode) {
        List<Flight> flights = flightService.findDepartingFlightsByAirport(airportCode);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/arriving")
    public ResponseEntity<List<Flight>> getAllArrivingFlights() {
        List<Flight> flights = flightService.findAllArrivingFlights();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/departing")
    public ResponseEntity<List<Flight>> getAllDepartingFlights() {
        List<Flight> flights = flightService.findAllDepartingFlights();
        return ResponseEntity.ok(flights);
    }
}
