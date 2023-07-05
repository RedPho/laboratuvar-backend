package com.emin.laboratuvar.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Optional;

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

    private String patientFirstName;
    private String patientLastName;
    private String patientTcNo;

    @ManyToOne
    @JoinColumn(name = "laborant_id", nullable = false)
    private Optional<Laborant> laborant;

    //file(photo of the report)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "filedb_id")
    private FileDB fileDB;

    public Report() {
    }

    public Report(String diagnosisTitle, String diagnosisDetails, LocalDateTime localDateTime, String patientFirstName, String patientLastName, String patientTcNo, Optional<Laborant> laborant) {
        this.diagnosisTitle = diagnosisTitle;
        this.diagnosisDetails = diagnosisDetails;
        this.localDateTime = localDateTime;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientTcNo = patientTcNo;
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

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientTcNo() {
        return patientTcNo;
    }

    public void setPatientTcNo(String patientTcNo) {
        this.patientTcNo = patientTcNo;
    }

    public Optional<Laborant> getLaborant() {
        return laborant;
    }

    public void setLaborant(Laborant laborant) {
        this.laborant = Optional.ofNullable(laborant);
    }

    public FileDB getFileDB() {
        return fileDB;
    }

    public void setFileDB(FileDB fileDB) {
        this.fileDB = fileDB;
    }
}
