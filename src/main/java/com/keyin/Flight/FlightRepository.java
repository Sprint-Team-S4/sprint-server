package com.keyin.Flight;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(path = "flights", collectionResourceRel = "flights")
public interface FlightRepository extends JpaRepository<Flight, Long> {
    public List<Flight> findByFlightNumber(@RequestParam String flightNumber);

    @Transactional
    @Modifying
    public List<Flight> deleteByFlightNumber(@RequestParam String flightNumber);
}