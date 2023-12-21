package com.keyin.Flight.Repository;

import com.keyin.Flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "flight", path = "flight")
public interface FlightRepository extends JpaRepository<Flight, Long> {

//    Find Arriving Flights by Airport - - - -
    @Query("SELECT f FROM Flight f WHERE f.flightStatus = :flightStatus AND f.airport.code = :airportCode")
    List<Flight> findArrivingFlightsByAirport(@Param("flightStatus") String flightStatus, @Param("airportCode") String airportCode);

//    Find Departing Flights by Airport - - - -
    @Query("SELECT f FROM Flight f WHERE f.flightStatus = :flightStatus AND f.airport.code = :airportCode")
    List<Flight> findDepartingFlightsByAirport(@Param("flightStatus") String flightStatus, @Param("airportCode") String airportCode);

//    Find All Arriving Flights - - - -
    @Query("SELECT f FROM Flight f WHERE f.flightStatus = 'Arriving'")
    List<Flight> findAllArrivingFlights();

//    Find All Departing Flights - - - -
    @Query("SELECT f FROM Flight f WHERE f.flightStatus = 'Departing'")
    List<Flight> findAllDepartingFlights();
}