package com.keyin.Gate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keyin.Airport.Airport;
import jakarta.persistence.*;

@Entity
public class Gate {

    //    Primary Key & Fields - - - -
    @Id
    @SequenceGenerator(name = "gate_sequence", sequenceName = "gate_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "gate_sequence")
    private long id;

    private String gateNumber;

    private String terminalNum;

    //    Relationships - - - -
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "airport_id")
    @JsonIgnore
    private Airport airport;

    //    Constructors - - - -
    public Gate() {
    }

    public Gate(long id, String gateNumber, String terminalNum, Airport airport) {
        this.id = id;
        this.gateNumber = gateNumber;
        this.terminalNum = terminalNum;
        this.airport = airport;
    }

    //    Getters & Setters - - - -
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
