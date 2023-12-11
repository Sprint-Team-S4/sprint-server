package com.keyin.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "passenger", path = "passenger")
public interface PassengersRestAPI extends JpaRepository<Passengers, Long> {

}