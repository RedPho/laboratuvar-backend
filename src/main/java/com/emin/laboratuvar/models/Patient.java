package com.emin.laboratuvar.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    private String tcNo;

    @OneToMany(mappedBy = "patient")
    private ArrayList<Report> reports;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String tcNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tcNo = tcNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }
}
