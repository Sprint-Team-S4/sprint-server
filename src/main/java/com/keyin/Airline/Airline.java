package com.keyin.Airline;

import com.keyin.Aircraft.Aircraft;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Airline {
    //    ;Primary Key & Fields - - - -

    @Id
    @SequenceGenerator(name = "airline_sequence", sequenceName = "airline_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "airline_sequence")
    private Long id;

    private String airlineName;

    private String contactEmail;

    //    ;Relationships - - - -

    @OneToMany
    private List<Aircraft> aircrafts;

    //    ;Getters & Setters - - - -

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
