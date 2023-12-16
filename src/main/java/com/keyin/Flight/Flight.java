package com.keyin.Flight;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Airline.Airline;
import com.keyin.Airport.Airport;
import com.keyin.City.City;
import com.keyin.Gate.Gate;
import com.keyin.Passengers.Passengers;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Flight {

//    ;Primary Key & Fields - - - -
    @Id
    @SequenceGenerator(name = "flight_sequence", sequenceName = "flight_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(generator = "flight_sequence")
    private long id;

    private String flightStatus; // Arrival/Departure

//    ;Relationships - - - -
    @OneToOne
    private City city;

    @OneToOne
    private Airport airport;

    @OneToOne
    private Airline airline;

    @OneToOne
    private Gate gate;

    @OneToOne
    private Aircraft aircraft;

    @OneToMany
    private List<Passengers> passengers;

//    ;Getters & Setters - - - -
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFlightNumber(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
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

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}