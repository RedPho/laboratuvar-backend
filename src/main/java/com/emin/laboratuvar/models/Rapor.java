package com.emin.laboratuvar.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "raporlar")
public class Rapor {

    //Dosya Numarasi
    @Id
    @GeneratedValue
    private long id;

    private String tani_basligi;

    private  String tani_detaylari;

    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime tarih_saat;

    @ManyToOne
    @JoinColumn(name = "hasta_id", nullable = false)
    private Hasta hasta;

    @ManyToOne
    @JoinColumn(name = "laborant_id", nullable = false)
    private Laborant laborant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "filedb_id")
    private FileDB fotograf;

    public Rapor() {
    }

    public Rapor(String tani_basligi, String tani_detaylari, LocalDateTime tarih_saat, Hasta hasta, Laborant laborant) {
        this.tani_basligi = tani_basligi;
        this.tani_detaylari = tani_detaylari;
        this.tarih_saat = tarih_saat;
        this.hasta = hasta;
        this.laborant = laborant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaniBasligi() {
        return tani_basligi;
    }

    public void setTaniBasligi(String tani_basligi) {
        this.tani_basligi = tani_basligi;
    }

    public String getTaniDetaylari() {
        return tani_detaylari;
    }

    public void setTaniDetaylari(String tani_detaylari) {
        this.tani_detaylari = tani_detaylari;
    }

    public LocalDateTime getTarihSaat() {
        return tarih_saat;
    }

    public void setTarihSaat(LocalDateTime tarih_saat) {
        this.tarih_saat = tarih_saat;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public Laborant getLaborant() {
        return laborant;
    }

    public void setLaborant(Laborant laborant) {
        this.laborant = laborant;
    }

    public FileDB getFotograf() {
        return fotograf;
    }

    public void setFotograf(FileDB fotograf) {
        this.fotograf = fotograf;
    }
}
