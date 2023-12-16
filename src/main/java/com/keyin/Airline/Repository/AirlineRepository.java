package com.keyin.Airline.Repository;

import com.keyin.Airline.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "airline", path = "airline")
public interface AirlineRepository extends JpaRepository<Airline, Long> {

}