//package com.keyin.Flight.Controller;
//
//import com.keyin.Aircraft.Aircraft;
//import com.keyin.Airline.Airline;
//import com.keyin.Airport.Airport;
//import com.keyin.City.City;
//import com.keyin.Flight.Flight;
//import com.keyin.Flight.Repository.FlightRepository;
//import com.keyin.Gate.Gate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/flight")
//public class FlightController {
//
////    ;Repository - - - -
//    @Autowired
//    private FlightRepository repo;
//
////    ;Get Flight Info - - - -
//    @GetMapping("/{id}")
//    public Flight getFlightInfo(@RequestParam long id) {
//        return repo.findById(id).orElse(null);
//    }
//
////    ;Get Flight Status (by flight id) - - - -
//    @GetMapping("/{id}/status")
//    public String getFlightStatus(@RequestParam long id) {
//        Flight flight = repo.findById(id).orElse(null);
//        return (flight != null) ? flight.getFlightStatus() : "Flight not found";
//    }
//
////    ;Get Passenger Count (by flight id) - - - -
//    @GetMapping("/{id}/passengers/count")
//    public int getPassengerCount(@RequestParam long id) {
//        Flight flight = repo.findById(id).orElse(null);
//        return (flight != null && flight.getPassengers() != null) ? flight.getPassengers().size() : 0;
//    }
//
////    ;Get Associated Aircraft (by flight id) - - - -
//    @GetMapping("/{id}/aircraft")
//    public Aircraft getAircraftInfo(@RequestParam long id) {
//        Flight flight = repo.findById(id).orElse(null);
//        return (flight != null) ? flight.getAircraft() : null;
//    }
//
////    ;Get Associated Airline (by flight id) - - - -
//    @GetMapping("/{id}/airline")
//    public Airline getAirlineInfo(@RequestParam long id) {
//        Flight flight = repo.findById(id).orElse(null);
//        return (flight != null) ? flight.getAirline() : null;
//    }
//
////    ;Get Associated Airport (by flight id) - - - -
//    @GetMapping("/{id}/airport")
//    public Airport getAirportInfo(@RequestParam long id) {
//        Flight flight = repo.findById(id).orElse(null);
//        return (flight != null) ? flight.getAirport() : null;
//    }
//
////    ;Get Associated Gate (by flight id) - - - -
//    @GetMapping("/{id}/gate")
//    public Gate getGateInfo(@RequestParam long id) {
//        Flight flight = repo.findById(id).orElse(null);
//        return (flight != null) ? flight.getGate() : null;
//    }
//
////    ;Get Associated City (by flight id) - - - -
//    @GetMapping("/{id}/city")
//    public City getCityInfo(@RequestParam long id) {
//        Flight flight = repo.findById(id).orElse(null);
//        return (flight != null) ? flight.getCity() : null;
//    }
//
////    ;Search Flights by Airline - - - -
//    @GetMapping("/search_by_airline")
//    public List<Flight> getFlightsByAirline(@RequestParam String airlineName) {
//        return (List<Flight>) repo.findByAirline_Name(airlineName);
//    }
//
////    ;Search Flights by Status - - - -
//    @GetMapping("/search_by_status")
//    public List<Flight> getFlightsByStatus(@RequestParam String flightStatus) {
//        return (List<Flight>) repo.findByStatus(flightStatus);
//    }
//
////    ;Search Flights by Airport - - - -
//    @GetMapping("/search_by_airport")
//    public List<Flight> getFlightsByAirport(@RequestParam String airportName) {
//        return (List<Flight>) repo.findByAirport(airportName);
//    }
//
////    ;Search Flights by City - - - -
//    @GetMapping("/search_by_city")
//    public List<Flight> getFlightsByCity(@RequestParam String cityName) {
//        return (List<Flight>) repo.findByCity(cityName);
//    }
//}

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

    @PostMapping
    public ResponseEntity<Flight> createFlight(@Valid @RequestBody Flight flight) {
        Flight newFlight = flightService.saveFlight(flight);
        return ResponseEntity.ok(newFlight);
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
}
