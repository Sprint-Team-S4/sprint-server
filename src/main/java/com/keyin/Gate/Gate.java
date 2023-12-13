package com.keyin.Gate;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Airport.Airport;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Gate {

//    ;Primary Key & Fields - - - -

    @Id
    @SequenceGenerator(name = "gate_sequence", sequenceName = "gate_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "gate_sequence")
    private Long id;

    private String gateNumber;

    private String terminalNum;

//    ;Relationships - - - -

    @ManyToOne
    private Airport airport;

    @ManyToMany
    private List<Aircraft> departures;

    @ManyToMany
    private List<Aircraft> arrivals;

//    ;Getters & Setters - - - -

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public List<Aircraft> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Aircraft> departures) {
        this.departures = departures;
    }

    public List<Aircraft> getArrivals() {
        return arrivals;
    }

    public void setArrivals(List<Aircraft> arrivals) {
        this.arrivals = arrivals;
    }
}
