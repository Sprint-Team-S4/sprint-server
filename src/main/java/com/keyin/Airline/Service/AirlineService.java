package com.keyin.Airline.Service;

import com.keyin.Airline.Airline;
import com.keyin.Airline.Repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public List<Airline> findAllAirlines() {
        return airlineRepository.findAll();
    }

    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public Optional<Airline> findAirlineById(Long id) {
        return airlineRepository.findById(id);
    }

    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }

    public Airline updateAirline(Long id, Airline airlineDetails) {
        Airline airline = airlineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airline not found for this id :: " + id));

        airline.setAirlineName(airlineDetails.getAirlineName());
        airline.setContactEmail(airlineDetails.getContactEmail());

        return airlineRepository.save(airline);
    }
}
