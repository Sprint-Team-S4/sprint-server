package com.keyin.Flight.Repository;

import com.keyin.City.City;
import com.keyin.Flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "flight", path = "flight")
public interface FlightRepository extends JpaRepository<Flight, Long> {

//    ;Find Flights by Airline - - - -
    @Query("SELECT c FROM Flight c JOIN c.airline p WHERE p.airlineName = :airlineName")
    List<Flight> findByAirline_Name(@Param("airlineName") String airlineName);

//    ;Find Flights by Status - - - -
@Query("SELECT f FROM Flight f WHERE f.flightStatus = :flightStatus")
    List<Flight> findByStatus(@Param("flightStatus") String flightStatus);

//    ;Find Flights by Airport - - - -
    @Query("SELECT c FROM Flight c JOIN c.airport p WHERE p.name = :airportName")
    List<Flight> findByAirport(@Param("airportName") String airportName);

//    ;Find Flights by City - - - -
    @Query("SELECT c FROM Flight c JOIN c.city p WHERE p.name = :cityName")
    List<Flight> findByCity(@Param("cityName") String cityName);
}