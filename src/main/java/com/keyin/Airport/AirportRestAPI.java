package com.keyin.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "airport", path = "airport")
public interface AirportRestAPI extends JpaRepository<Airport, Long> {

}