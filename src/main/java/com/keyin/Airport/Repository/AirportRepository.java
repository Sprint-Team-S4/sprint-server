package com.keyin.Airport.Repository;

import com.keyin.Airport.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "airport", path = "airport")
public interface AirportRepository extends JpaRepository<Airport, Long> {
}