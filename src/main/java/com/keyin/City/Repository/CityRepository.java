package com.keyin.City.Repository;

import com.keyin.City.City;
import com.keyin.Flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface CityRepository extends JpaRepository<City, Long> {

//    ;Find City by Airport - - - -
    @Query("SELECT c FROM City c JOIN c.airport p WHERE p.name = :airportName")
    City findByAirport(@Param("airportName") String airportName);
}