package com.emin.laboratuvar.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name="hastalar")
public class Hasta {
    @Id
    @GeneratedValue
    private long id;

    private String ad;

    private String soyad;

    private String tc_kimlik_no;

    @OneToMany(mappedBy = "hasta")
    private ArrayList<Rapor> raporlar;

    public Hasta() {
    }

    public Hasta(String ad, String soyad, String tc_kimlik_no) {
        this.ad = ad;
        this.soyad = soyad;
        this.tc_kimlik_no = tc_kimlik_no;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTc_kimlik_no() {
        return tc_kimlik_no;
    }

    public void setTc_kimlik_no(String tc_kimlik_no) {
        this.tc_kimlik_no = tc_kimlik_no;
    }

    public ArrayList<Rapor> getRaporlar() {
        return raporlar;
    }

    public void setRaporlar(ArrayList<Rapor> raporlar) {
        this.raporlar = raporlar;
    }
}
