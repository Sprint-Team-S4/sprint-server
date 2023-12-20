package com.keyin.Aircraft;

import com.keyin.Airline.Airline;
import jakarta.persistence.*;

@Entity
public class Aircraft {

    //    Primary Key & Fields - - - -
    @Id
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "aircraft_sequence")
    private long id;

    //    Relationships - - - -
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    public Aircraft(long id, Airline airline) {
        this.id = id;
        this.airline = airline;
    }

    //    Getters & Setters - - - -
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}