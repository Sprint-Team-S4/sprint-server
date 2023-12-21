package com.keyin.Gate.Controller;

import com.keyin.Gate.Gate;
import com.keyin.Gate.Service.GateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gate")
@CrossOrigin
public class GateController {

    private final GateService gateService;

    @Autowired
    public GateController(GateService gateService) {
        this.gateService = gateService;
    }

    @GetMapping
    public ResponseEntity<List<Gate>> getAllGates() {
        List<Gate> gates = gateService.getAllGates();
        return ResponseEntity.ok(gates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gate> getGateById(@PathVariable Long id) {
        Gate gate = gateService.getGateById(id)
                .orElse(null);
        if (gate != null) {
            return ResponseEntity.ok(gate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Gate> createGate(@Valid @RequestBody Gate gate) {
        Gate createdGate = gateService.createGate(gate);
        return ResponseEntity.ok(createdGate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gate> updateGate(@PathVariable Long id, @Valid @RequestBody Gate gate) {
        Gate updatedGate = gateService.updateGate(id, gate);
        if (updatedGate != null) {
            return ResponseEntity.ok(updatedGate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGate(@PathVariable Long id) {
        gateService.deleteGate(id);
        return ResponseEntity.noContent().build();
    }
}
