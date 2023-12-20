package com.keyin.Gate.Repository;

import com.keyin.Airport.Airport;
import com.keyin.Gate.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "gate", path = "gate")
public interface GateRepository extends JpaRepository<Gate, Long> {
    List<Gate> findByAirport(Airport airport);
}