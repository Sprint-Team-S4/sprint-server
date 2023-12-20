package com.keyin.Airport;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(path = "airport", collectionResourceRel = "airport")
public interface AirportRepository extends JpaRepository<Airport, Long> {
    public List<Airport> searchByCode(@RequestParam String code);

    @Transactional
    @Modifying
    public List<Airport> deleteByCode(@RequestParam String code);
}