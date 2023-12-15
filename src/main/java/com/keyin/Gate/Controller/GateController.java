package com.keyin.Gate.Controller;

import com.keyin.City.City;
import com.keyin.Gate.Gate;
import com.keyin.Gate.Repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/gate")
public class GateController {

//    ;Repository - - - -
    @Autowired
    private GateRepository repo;

//    ;List All Gates - - - -
    @GetMapping("/all")
    public List<Gate> getAllGates() {
        return (List<Gate>) repo.findAll();
    }

//    ;Add Gate - - - -
    @PostMapping("/add")
    public void createGate(@RequestBody Gate gate) {
        repo.save(gate);
    }

//    ;Change Gate Number (by id) - - - -
    @PutMapping("/{id}")
    public void updateGate(@PathVariable String id, @RequestBody Gate gate, HttpServletResponse response) {
        Optional<Gate> returnValue = repo.findById(Long.parseLong(id));
        Gate gateToUpdate;

        if (returnValue.isPresent()) {
            gateToUpdate = returnValue.get();

            gateToUpdate.setGateNumber(gate.getGateNumber());

            repo.save(gateToUpdate);
        } else {
            try {
                response.sendError(404, "Gate with id: " + gate.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
