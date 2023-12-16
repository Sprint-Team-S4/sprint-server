package com.keyin.Aircraft;

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

    private String airlineName;

    //    ;Relationships - - - -
    @ManyToMany
    private List<Passengers> passengers;

    @ManyToMany
    private List<Airport> airports;

    //    ;Getters & Setters - - - -
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Airport> getAirports() {return airports;}

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

}