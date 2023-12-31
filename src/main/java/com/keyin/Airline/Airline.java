package com.keyin.Airline;

import com.keyin.Aircraft.Aircraft;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Airline {

    //    Primary Key & Fields - - - -
    @Id
    @SequenceGenerator(name = "airline_sequence", sequenceName = "airline_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "airline_sequence")
    private long id;

    private String airlineName;

    private String contactEmail;

    //    Relationships - - - -
    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL)
    private List<Aircraft> aircrafts = new ArrayList<>();

    //    Constructors - - - -
    public Airline(){}

    public Airline(long id, String airlineName, String contactEmail, List<Aircraft> aircrafts) {
        this.id = id;
        this.airlineName = airlineName;
        this.contactEmail = contactEmail;
        this.aircrafts = aircrafts;
    }

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
