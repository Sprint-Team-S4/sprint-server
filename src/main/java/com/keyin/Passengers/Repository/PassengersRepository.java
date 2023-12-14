package com.keyin.Passengers.Repository;

import com.keyin.Passengers.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "passenger", path = "passenger")
public interface PassengersRepository extends JpaRepository<Passengers, Long> {

}