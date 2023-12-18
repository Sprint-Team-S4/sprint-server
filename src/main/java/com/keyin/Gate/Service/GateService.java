package com.keyin.Gate.Service;

import com.keyin.Gate.Gate;
import com.keyin.Gate.Repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GateService {

    private final GateRepository gateRepository;

    @Autowired
    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public List<Gate> getAllGates() {
        return gateRepository.findAll();
    }

    public Optional<Gate> getGateById(Long id) {
        return gateRepository.findById(id);
    }

    public Gate createGate(Gate gate) {
        return gateRepository.save(gate);
    }

    public Gate updateGate(Long id, Gate gateDetails) {
        Optional<Gate> optionalGate = gateRepository.findById(id);
        if (optionalGate.isPresent()) {
            Gate gate = optionalGate.get();
            gate.setGateNumber(gateDetails.getGateNumber());
            gate.setTerminalNum(gateDetails.getTerminalNum());
            gate.setAirport(gateDetails.getAirport());
            return gateRepository.save(gate);
        }
        return null;
    }

    public void deleteGate(Long id) {
        gateRepository.deleteById(id);
    }
}
