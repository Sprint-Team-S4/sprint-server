package com.keyin.Gate.Controller;

import com.keyin.Gate.Gate;
import com.keyin.Gate.Repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class GateController {
    @Autowired
    private GateRepository repo;

    @GetMapping("/gates")
    public List<Gate> getAllGates() {
        return (List<Gate>) repo.findAll();
    }

    @PostMapping("/gate")
    public void createGate(@RequestBody Gate gate) {
        repo.save(gate);
    }
}
