package com.keyin.Airport;

import com.keyin.City.City;
import com.keyin.Gate.Gate;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport {

    //    Primary Key & Fields - - - -
    @Id
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "airport_sequence")
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String code;

    //    Relationships - - - -
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = true)
    private City city;

    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private List<Gate> gates = new ArrayList<>();

    public Airport(long id, String name, String code, City city, List<Gate> gates) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.city = city;
        this.gates = gates;
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