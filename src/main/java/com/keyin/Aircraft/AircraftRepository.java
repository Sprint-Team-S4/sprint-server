package com.keyin.Aircraft;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(path = "aircraft", collectionResourceRel = "aircraft")
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
    public List<Aircraft> findByTailnumber(@RequestParam String tailnumber);

    @Transactional
    @Modifying
    public List<Aircraft> deleteByTailnumber(@RequestParam String tailnumber);
}