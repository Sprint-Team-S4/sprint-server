package com.keyin.City;
;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(path = "city", collectionResourceRel = "city")
public interface CityRepository extends JpaRepository<City, Long> {
    public List<City> findByCityname(@RequestParam String cityname);

    @Transactional
    @Modifying
    public List<City> deleteByCityname(@RequestParam String cityname);
}