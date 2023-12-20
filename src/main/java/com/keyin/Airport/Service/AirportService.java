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
}

