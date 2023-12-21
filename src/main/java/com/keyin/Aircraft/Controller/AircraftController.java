package com.keyin.Aircraft.Controller;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Aircraft.Service.AircraftService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")
@CrossOrigin(origins = "http://localhost:3000")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public ResponseEntity<List<Aircraft>> getAllAircrafts() {
        List<Aircraft> aircrafts = aircraftService.getAllAircrafts();
        return ResponseEntity.ok(aircrafts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        Aircraft aircraft = aircraftService.getAircraftById(id)
                .orElseThrow(() -> new RuntimeException("Aircraft not found for this id :: " + id));
        return ResponseEntity.ok(aircraft);
    }

    @PostMapping
    public ResponseEntity<Aircraft> createAircraft(@Valid @RequestBody Aircraft aircraft) {
        Aircraft newAircraft = aircraftService.saveAircraft(aircraft);
        return ResponseEntity.ok(newAircraft);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @Valid @RequestBody Aircraft aircraftDetails) {
        Aircraft updatedAircraft = aircraftService.updateAircraft(id);
        return ResponseEntity.ok(updatedAircraft);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
        return ResponseEntity.noContent().build();
    }
}
