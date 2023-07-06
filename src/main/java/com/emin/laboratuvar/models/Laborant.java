package com.emin.laboratuvar.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    @JsonIgnoreProperties({"laborant"})
    private List<Report> reports;

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

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
