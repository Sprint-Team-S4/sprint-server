package com.keyin.Flight.Controller;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Airline.Airline;
import com.keyin.Airport.Airport;
import com.keyin.City.City;
import com.keyin.Flight.Flight;
import com.keyin.Flight.Repository.FlightRepository;
import com.keyin.Gate.Gate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/flight")
public class FlightController {

//    ;Repository - - - -
    @Autowired
    private FlightRepository repo;

//    ;Get Flight Info - - - -
    @GetMapping("/{id}")
    public Flight getFlightInfo(@RequestParam long id) {
        return repo.findById(id).orElse(null);
    }

//    ;Get Flight Status (by flight id) - - - -
    @GetMapping("/{id}/status")
    public String getFlightStatus(@RequestParam long id) {
        Flight flight = repo.findById(id).orElse(null);
        return (flight != null) ? flight.getFlightStatus() : "Flight not found";
    }

//    ;Get Passenger Count (by flight id) - - - -
    @GetMapping("/{id}/passengers/count")
    public int getPassengerCount(@RequestParam long id) {
        Flight flight = repo.findById(id).orElse(null);
        return (flight != null && flight.getPassengers() != null) ? flight.getPassengers().size() : 0;
    }

//    ;Get Associated Aircraft (by flight id) - - - -
    @GetMapping("/{id}/aircraft")
    public Aircraft getAircraftInfo(@RequestParam long id) {
        Flight flight = repo.findById(id).orElse(null);
        return (flight != null) ? flight.getAircraft() : null;
    }

//    ;Get Associated Airline (by flight id) - - - -
    @GetMapping("/{id}/airline")
    public Airline getAirlineInfo(@RequestParam long id) {
        Flight flight = repo.findById(id).orElse(null);
        return (flight != null) ? flight.getAirline() : null;
    }

//    ;Get Associated Airport (by flight id) - - - -
    @GetMapping("/{id}/airport")
    public Airport getAirportInfo(@RequestParam long id) {
        Flight flight = repo.findById(id).orElse(null);
        return (flight != null) ? flight.getAirport() : null;
    }

//    ;Get Associated Gate (by flight id) - - - -
    @GetMapping("/{id}/gate")
    public Gate getGateInfo(@RequestParam long id) {
        Flight flight = repo.findById(id).orElse(null);
        return (flight != null) ? flight.getGate() : null;
    }

//    ;Get Associated City (by flight id) - - - -
    @GetMapping("/{id}/city")
    public City getCityInfo(@RequestParam long id) {
        Flight flight = repo.findById(id).orElse(null);
        return (flight != null) ? flight.getCity() : null;
    }

//    ;Search Flights by Airline - - - -
    @GetMapping("/search_by_airline")
    public List<Flight> getFlightsByAirline(@RequestParam String airlineName) {
        return (List<Flight>) repo.findByAirline_Name(airlineName);
    }

//    ;Search Flights by Status - - - -
    @GetMapping("/search_by_status")
    public List<Flight> getFlightsByStatus(@RequestParam String flightStatus) {
        return (List<Flight>) repo.findByStatus(flightStatus);
    }

//    ;Search Flights by Airport - - - -
    @GetMapping("/search_by_airport")
    public List<Flight> getFlightsByAirport(@RequestParam String airportName) {
        return (List<Flight>) repo.findByAirport(airportName);
    }

//    ;Search Flights by City - - - -
    @GetMapping("/search_by_city")
    public List<Flight> getFlightsByCity(@RequestParam String cityName) {
        return (List<Flight>) repo.findByCity(cityName);
    }
}
