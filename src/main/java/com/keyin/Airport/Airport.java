package com.keyin.Airport;

import com.keyin.Gate.Gate;
import com.keyin.Passengers.Passengers;
import jakarta.persistence.*;
import com.keyin.City.City;

import java.util.List;

@Entity
public class Airport {

    //    ;Primary Key & Fields - - - -
    @Id
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1, initialValue=2)
    @GeneratedValue(generator = "airport_sequence")
    private long id;

    private String name;

    private String code;

    //    ;Relationships - - - -
    @ManyToOne
    private City city;

    @OneToMany
    private List<Gate> gates;

    //    ;Getters & Setters - - - -
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}