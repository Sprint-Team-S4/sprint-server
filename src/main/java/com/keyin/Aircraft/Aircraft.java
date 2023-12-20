package com.keyin.Aircraft;

import jakarta.persistence.*;
import com.keyin.Airline.Airline;
import com.keyin.Flight.Flight;

import java.util.List;

@Entity
public class Aircraft {
    @Id
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "aircraft_sequence")
    private Long id;

    private String tailnumber;

    private String brand;

    private String model;

    @OneToOne
    private Airline airline;

    @OneToMany
    private List<Flight> flights;

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTailnumber() {
        return tailnumber;
    }

    public void setTailnumber(String tailnumber) {
        this.tailnumber = tailnumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}