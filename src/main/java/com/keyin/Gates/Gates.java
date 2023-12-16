package com.keyin.Gates;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Gates {
    @Id
    @SequenceGenerator(name = "gate_sequence", sequenceName = "gate_sequence", allocationSize = 1, initialValue=2)
    @GeneratedValue(generator = "gate_sequence")
    private long id;
    private String terminalNum;
    private String gateNumber;

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }
}
