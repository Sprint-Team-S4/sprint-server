package com.keyin.Passengers.Service;

import com.keyin.Passengers.Passengers;
import com.keyin.Passengers.Repository.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengersService {

    private final PassengersRepository passengersRepository;

    @Autowired
    public PassengersService(PassengersRepository passengersRepository) {
        this.passengersRepository = passengersRepository;
    }

    public List<Passengers> getAllPassengers() {
        return passengersRepository.findAll();
    }

    public Optional<Passengers> getPassengerById(Long id) {
        return passengersRepository.findById(id);
    }

    public Passengers createPassenger(Passengers passengers) {
        return passengersRepository.save(passengers);
    }

    public Passengers updatePassenger(Long id, Passengers passengerDetails) {
        Optional<Passengers> optionalPassenger = passengersRepository.findById(id);
        if (optionalPassenger.isPresent()) {
            Passengers passenger = optionalPassenger.get();
            passenger.setFirstName(passengerDetails.getFirstName());
            passenger.setLastName(passengerDetails.getLastName());
            passenger.setPhoneNumber(passengerDetails.getPhoneNumber());
            return passengersRepository.save(passenger);
        }
        return null;
    }

    public void deletePassenger(Long id) {
        passengersRepository.deleteById(id);
    }
}
