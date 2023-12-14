package com.keyin.Gates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "gate", path = "gate")
public interface GatesRestAPI extends JpaRepository<Gates, Long> {

}