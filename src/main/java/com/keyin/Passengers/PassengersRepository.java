package com.keyin.Passengers;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;

@RepositoryRestResource(path = "passenger", collectionResourceRel = "passenger")
public interface PassengersRepository extends JpaRepository<Passengers, Long> {
}