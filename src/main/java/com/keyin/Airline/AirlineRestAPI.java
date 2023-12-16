package com.keyin.Airline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "airline", path = "airline")
public interface AirlineRestAPI extends JpaRepository<Airline, Long> {

}
