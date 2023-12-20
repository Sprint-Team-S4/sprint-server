package com.keyin.Airport.Service;

import com.keyin.Airport.Airport;
import com.keyin.Airport.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Optional<Airport> findAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

    public Airport updateAirport(Long id, Airport airportDetails) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found for this id :: " + id));

        airport.setName(airportDetails.getName());
        airport.setCode(airportDetails.getCode());

        return airportRepository.save(airport);
    }

    public List<Airport> initializeAirports() {
        List<Airport> airports = new ArrayList<>();

        // AIRPORT 1
        Airport airport1 = new Airport();
        airport1.setName("St. John's Airport");
        airport1.setCode("YYT");
        airport1.setCity(null);
        airport1.setGates(null);
        airports.add(airport1);

        // AIRPORT 2
        Airport airport2 = new Airport();
        airport2.setName("Toronto Airport");
        airport2.setCode("YYZ");
        airport2.setCity(null);
        airport2.setGates(null);
        airports.add(airport2);

        // AIRPORT 3
        Airport airport3 = new Airport();
        airport3.setName("Keflavik Airport");
        airport3.setCode("KEF");
        airport3.setCity(null);
        airport3.setGates(null);
        airports.add(airport3);

        // AIRPORT 4
        Airport airport4 = new Airport();
        airport4.setName("Dulles International Airport");
        airport4.setCode("IAD");
        airport4.setCity(null);
        airport4.setGates(null);
        airports.add(airport4);

        // AIRPORT 5
        Airport airport5 = new Airport();
        airport5.setName("Stockholm Arlanda Airport");
        airport5.setCode("ARN");
        airport5.setCity(null);
        airport5.setGates(null);
        airports.add(airport5);

        return airportRepository.saveAll(airports);
    }
}

