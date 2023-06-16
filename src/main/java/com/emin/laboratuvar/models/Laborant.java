package com.emin.laboratuvar.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "laborantlar")
public class Laborant {
    @Id
    @GeneratedValue
    private long id;

    private String ad;

    private String soyad;

    private String hastane_kimlik_no;

    @OneToMany(mappedBy = "laborant")
    private ArrayList<Rapor> raporlar;
}
