package com.keyin.Admin;

import jakarta.persistence.*;

@Entity
public class Admin {

    //    Primary Key & Fields - - - -
    @Id
    @SequenceGenerator(name = "admin_sequence", sequenceName = "admin_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "admin_sequence")
    private long id;

    private String username;

    private String password;

    //    Constructors - - - -
    public Admin(){}

    public Admin(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //    Getters & Setters - - - -
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}