package com.keyin.Gate.Controller;

import com.keyin.Gate.Gate;
import com.keyin.Gate.Repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/gate")
public class GateController {
    @Autowired
    private GateRepository repo;

    @GetMapping("/allgates")
    public List<Gate> getAllGates() {
        return (List<Gate>) repo.findAll();
    }

    @PostMapping("/creategate")
    public void createGate(@RequestBody Gate gate) {
        repo.save(gate);
    }
}
