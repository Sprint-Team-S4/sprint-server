package com.keyin.Flight;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Airport.Airport;
import jakarta.persistence.*;

@Entity
public class Flight {

    @Id
    @SequenceGenerator(name = "flight_sequence", sequenceName = "flight_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "flight_sequence")
    private long id;

    private String flightNumber;

    @OneToOne
    private Airport origin;

    @OneToOne
    private Airport destination;

    @OneToOne
    private Aircraft aircraft;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }
}