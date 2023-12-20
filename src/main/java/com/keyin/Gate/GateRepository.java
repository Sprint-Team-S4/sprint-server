package com.keyin.Gate;

import com.keyin.Airport.Airport;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(path = "gates", collectionResourceRel = "gates")
public interface GateRepository extends JpaRepository<Gates, Long> {
    public List<Gates> findByAirport(@RequestParam Airport airportCode);
}