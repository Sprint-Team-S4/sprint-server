package com.keyin.City;

import com.keyin.Passengers.Passengers;
import jakarta.persistence.*;

@Entity
public class City {

    //    ;Primary Key & Fields - - - -
    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "city_sequence")
    private long id;

    private String name;

    //    ;Relationships - - - -
    @ManyToOne
    private Passengers passengers;

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
}