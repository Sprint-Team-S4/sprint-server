package com.keyin.Flight;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Airport.Airport;
import com.keyin.Gate.Gate;
import com.keyin.Passengers.Passengers;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Flight {

    //    Primary Key & Fields - - - -
    @Id
    @SequenceGenerator(name = "flight_sequence", sequenceName = "flight_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "flight_sequence")
    private long id;

    private String flightStatus; // Arriving/Departing

    private String flightNumber;

    //    Relationships - - - -
    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    @ManyToOne
    @JoinColumn(name = "gate_id")
    private Gate gate;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "flight_id")
    private List<Passengers> passengers = new ArrayList<>();

    //    Constructors - - - -
    public Flight() {}

    public Flight(long id, String flightStatus, String flightNumber, Airport airport, Gate gate, Aircraft aircraft, List<Passengers> passengers) {
        this.id = id;
        this.flightStatus = flightStatus;
        this.flightNumber = flightNumber;
        this.airport = airport;
        this.gate = gate;
        this.aircraft = aircraft;
        this.passengers = passengers;
    }

    //    Getters & Setters - - - -
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public List<Passengers> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passengers> passengers) {
        this.passengers = passengers;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

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
}