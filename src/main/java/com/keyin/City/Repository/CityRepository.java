package com.keyin.City.Repository;

import com.keyin.City.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT c FROM City c JOIN c.passengers p WHERE p.lastName = :passengerName")
    List<City> findByPassenger_Name(@Param("passengerName") String passengerName);
}