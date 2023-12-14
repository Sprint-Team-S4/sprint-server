package com.keyin.Aircraft;

import com.keyin.Gate.Gate;
import com.keyin.Passengers.Passengers;
import jakarta.persistence.*;
import com.keyin.Airport.Airport;
import java.util.List;

@Entity
public class Aircraft {
    //    ;Primary Key & Fields - - - -

    @Id
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "aircraft_sequence")
    private long id;

    private String type;

    private String airlineName;

    private int numberOfPassengers;

    //    ;Relationships - - - -

    @ManyToMany
    private List<Passengers> passengers;

    @ManyToMany
    private List<Airport> airports;

    @ManyToOne
    private Gate departureGate;

    @ManyToOne
    private Gate arrivalGate;

    //    ;Getters & Setters - - - -

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirLine() {
        return airlineName;
    }

    public void setAirLine(String airLine) {
        this.airlineName = airLine;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public List<Airport> getAirports() {return airports;}

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public List<Passengers> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passengers> passengers) {
        this.passengers = passengers;
    }

    public Gate getDepartureGate() {
        return departureGate;
    }

    public void setDepartureGate(Gate departureGate) {
        this.departureGate = departureGate;
    }

    public Gate getArrivalGate() {
        return arrivalGate;
    }

    public void setArrivalGate(Gate arrivalGate) {
        this.arrivalGate = arrivalGate;
    }
}