package com.emin.laboratuvar.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    private String patientFirstName;
    private String patientLastName;
    private String patientTcNo;

    @ManyToOne
    @JoinColumn(name = "laborant_id")
    @JsonIgnoreProperties({"reports"}) // ayni json icinde birbirini tekrar eden propertyler olmamasi icin(x verisi icinde y verisi var. y verisi icinde de x verisi olunca y{x{y{x{y...}}}} diye bir sonsuz dongu olusmakta.)
    private Laborant laborant;

    //file(photo of the report)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "filedb_id")
    @JsonIgnoreProperties({"report"})
    private FileDB fileDB;

    public Report() {
    }

    public Report(String diagnosisTitle, String diagnosisDetails, LocalDateTime localDateTime, String patientFirstName, String patientLastName, String patientTcNo, Laborant laborant, FileDB fileDB) {
        this.diagnosisTitle = diagnosisTitle;
        this.diagnosisDetails = diagnosisDetails;
        this.localDateTime = localDateTime;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientTcNo = patientTcNo;
        this.laborant = laborant;
        this.fileDB = fileDB;
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
