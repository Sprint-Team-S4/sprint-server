package com.keyin.Gate.Repository;

import com.keyin.Gate.Gate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends CrudRepository<Gate, Long> {

}
