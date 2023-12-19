package com.keyin.Gate;

import com.keyin.Airport.Airport;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Gate {

    //    Primary Key & Fields - - - -
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String gateNumber;

    @NotNull
    private String terminalNum;

    //    Relationships - - - -

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

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
