package com.keyin.Aircraft.Repository;

import com.keyin.Aircraft.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "aircraft", path = "aircraft")
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

}