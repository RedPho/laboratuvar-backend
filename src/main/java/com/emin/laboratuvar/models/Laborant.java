package com.emin.laboratuvar.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "laborants")
public class Laborant {
    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    private String hospitalIdentityNo;

    @OneToMany(mappedBy = "laborant")
    private ArrayList<Report> reports;

    public Laborant() {
    }

    public Laborant(String firstName, String lastName, String hospitalIdentityNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospitalIdentityNo = hospitalIdentityNo;
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

    public String getHospitalIdentityNo() {
        return hospitalIdentityNo;
    }

    public void setHospitalIdentityNo(String hospitalIdentityNo) {
        this.hospitalIdentityNo = hospitalIdentityNo;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }
}
