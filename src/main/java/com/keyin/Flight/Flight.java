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

    private String flightNumber;

//    ;Relationships - - - -
    @ManyToOne
    private City city;

    @ManyToOne
    private Airport airport;

    @ManyToOne
    private Airline airline;

    @ManyToOne
    private Gate gate;

    @ManyToOne
    private Aircraft aircraft;

    @ManyToMany
    private List<Passengers> passengers;

//    ;Getters & Setters - - - -
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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