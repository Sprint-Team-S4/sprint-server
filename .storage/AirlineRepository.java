package com.keyin.Airline.Repository;

import com.keyin.Airline.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Long> {
}
