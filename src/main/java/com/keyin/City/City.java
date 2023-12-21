package com.keyin.City;

import com.keyin.Airport.Airport;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class City {

    //    Primary Key & Fields - - - -
    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "city_sequence")
    private long id;

    private String name;

    private String country;

    //    Relationships - - - -
    @OneToMany(mappedBy = "city", cascade = CascadeType.PERSIST)
    private List<Airport> airports = new ArrayList<>();

    //    Constructors - - - -
    public City(){}

    public City(long id, String name, String country, List<Airport> airports) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.airports = airports;
    }

    //    Getters & Setters - - - -
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}