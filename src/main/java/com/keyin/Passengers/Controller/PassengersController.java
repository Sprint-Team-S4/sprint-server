package com.keyin.Passengers.Controller;

import com.keyin.Passengers.Passengers;
import com.keyin.Passengers.Service.PassengersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengersController {

    private final PassengersService passengersService;

    @Autowired
    public PassengersController(PassengersService passengersService) {
        this.passengersService = passengersService;
    }

    @GetMapping
    public ResponseEntity<List<Passengers>> getAllPassengers() {
        List<Passengers> passengers = passengersService.getAllPassengers();
        return ResponseEntity.ok(passengers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passengers> getPassengerById(@PathVariable Long id) {
        Passengers passenger = passengersService.getPassengerById(id)
                .orElse(null);
        if (passenger != null) {
            return ResponseEntity.ok(passenger);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Passengers> createPassenger(@Valid @RequestBody Passengers passengers) {
        Passengers createdPassenger = passengersService.createPassenger(passengers);
        return ResponseEntity.ok(createdPassenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passengers> updatePassenger(@PathVariable Long id, @Valid @RequestBody Passengers passengers) {
        Passengers updatedPassenger = passengersService.updatePassenger(id, passengers);
        if (updatedPassenger != null) {
            return ResponseEntity.ok(updatedPassenger);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengersService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}
