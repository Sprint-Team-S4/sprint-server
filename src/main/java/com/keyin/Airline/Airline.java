package com.keyin.Airline;

import com.keyin.Aircraft.Aircraft;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Airline {

    //    Primary Key & Fields - - - -
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String airlineName;

    @NotNull
    private String contactEmail;

    //    Relationships - - - -
    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL)
    private List<Aircraft> aircrafts = new ArrayList<>();

    //    Getters & Setters - - - -
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }
}
