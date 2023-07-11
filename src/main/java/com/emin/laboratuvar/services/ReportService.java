package com.emin.laboratuvar.services;

import com.emin.laboratuvar.models.FileDB;
import com.emin.laboratuvar.models.Laborant;
import com.emin.laboratuvar.models.Report;
import com.emin.laboratuvar.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private LaborantService laborantService;


    public Report store(String diagnosisTitle, String diagnosisDetails, String patientFirstName, String patientLastName, String patientTcNo, Laborant laborant, FileDB fileDB) {
        Report report = new Report(diagnosisTitle, diagnosisDetails, LocalDateTime.now(), patientFirstName, patientLastName, patientTcNo, laborant, fileDB);
        return reportRepository.save(report);

    }

    public Report update(Long id, String diagnosisTitle, String diagnosisDetails, String patientFirstName, String patientLastName, String patientTcNo, Laborant laborant) {
        Optional<Report> report = reportRepository.findById(id);
        if (report.isPresent()) {
            Report reportObj = report.get();
            reportObj.setDiagnosisTitle(diagnosisTitle);
            reportObj.setDiagnosisDetails(diagnosisDetails);
            reportObj.setPatientFirstName(patientFirstName);
            reportObj.setPatientLastName(patientLastName);
            reportObj.setPatientTcNo(patientTcNo);
            reportObj.setLaborant(laborant);
            reportObj.setLocalDateTime(LocalDateTime.now());
            return reportObj;
        } else {
            return null;
        }
    }

    public Optional<Report> getById(long id) {
        return reportRepository.findById(id);
    }
    public List<Report> getByPatientFirstNameContaining(String firstName) { return reportRepository.findByPatientFirstNameContaining(firstName); };
    public List<Report> getByPatientLastNameContaining(String lastName) { return reportRepository.findByPatientLastNameContaining(lastName); };

    public List<Report> getByPatientTcNo(String tcNo) { return reportRepository.findByPatientTcNo(tcNo); };


    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    public void deleteById(Long id) {
        reportRepository.deleteById(id);
    }
}
