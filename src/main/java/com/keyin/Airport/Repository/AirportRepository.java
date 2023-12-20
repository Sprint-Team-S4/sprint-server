package com.keyin.Airport.Repository;

import com.keyin.Airport.Airport;
import com.keyin.City.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "airport", path = "airport")
public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findByCity(City city);
}

