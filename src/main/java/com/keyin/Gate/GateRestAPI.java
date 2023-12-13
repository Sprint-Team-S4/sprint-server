package com.keyin.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "gate", path = "gate")
public interface GateRestAPI extends JpaRepository<Gate, Long> {

}