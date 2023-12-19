package com.keyin.Flight.Service;

import com.keyin.Flight.Flight;
import com.keyin.Flight.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flightDetails) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found for this id :: " + id));
        flight.setFlightStatus(flightDetails.getFlightStatus());
        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setAirport(flightDetails.getAirport());
        flight.setAirline(flightDetails.getAirline());
        flight.setGate(flightDetails.getGate());
        flight.setAircraft(flightDetails.getAircraft());
        flight.setPassengers(flightDetails.getPassengers());
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> findArrivingFlightsByAirport(String airportCode) {
        return flightRepository.findArrivingFlightsByAirport("Arriving", airportCode);
    }

    public List<Flight> findDepartingFlightsByAirport(String airportCode) {
        return flightRepository.findDepartingFlightsByAirport("Departing", airportCode);
    }
}
