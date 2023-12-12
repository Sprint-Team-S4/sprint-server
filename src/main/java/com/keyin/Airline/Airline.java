package com.keyin.Airline;
import com.keyin.Aircraft.Aircraft;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Airline {
    @Id
    @SequenceGenerator(name = "airline_sequence", sequenceName = "airline_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "airline_sequence")
    private long id;
    private String airlineName;
    private String contactEmail;

    @OneToMany
    private List<Aircraft> aircrafts;

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
}
