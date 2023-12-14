package com.keyin.City.Repository;

import com.keyin.City.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository
        extends CrudRepository<City, Long> {

    public List<City> findByPassenger_Name(String passengerName);
}