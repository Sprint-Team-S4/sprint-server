package com.keyin.Airline;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(path = "airline", collectionResourceRel = "airline")
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    public List<Airline> findByAirlineCode(@RequestParam String airlineCode);

    @Transactional
    @Modifying
    public List<Airline> deleteByAirlineCode(@RequestParam String airlineCode);
}