package com.keyin.Passengers.Repository;

import com.keyin.Passengers.Passengers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepository extends CrudRepository<Passengers, Long> {

}
