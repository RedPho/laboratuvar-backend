package com.emin.laboratuvar.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue
    private long id;

    private String diagnosisTitle;

    private String diagnosisDetails;

    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "laborant_id", nullable = false)
    private Laborant laborant;

    //file(photo of the report)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "filedb_id")
    private FileDB fileDB;

    public Report() {
    }

    public Report(String diagnosisTitle, String diagnosisDetails, LocalDateTime localDateTime, Patient patient, Laborant laborant) {
        this.diagnosisTitle = diagnosisTitle;
        this.diagnosisDetails = diagnosisDetails;
        this.localDateTime = localDateTime;
        this.patient = patient;
        this.laborant = laborant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiagnosisTitle() {
        return diagnosisTitle;
    }

    public void setDiagnosisTitle(String diagnosisTitle) {
        this.diagnosisTitle = diagnosisTitle;
    }

    public String getDiagnosisDetails() {
        return diagnosisDetails;
    }

    public void setDiagnosisDetails(String diagnosisDetails) {
        this.diagnosisDetails = diagnosisDetails;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Laborant getLaborant() {
        return laborant;
    }

    public void setLaborant(Laborant laborant) {
        this.laborant = laborant;
    }

    public FileDB getFileDB() {
        return fileDB;
    }

    public void setFileDB(FileDB fileDB) {
        this.fileDB = fileDB;
    }
}
