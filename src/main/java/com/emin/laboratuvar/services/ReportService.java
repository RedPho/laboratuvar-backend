package com.emin.laboratuvar.services;

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


    public Report store(String diagnosisTitle, String diagnosisDetails, String patientFirstName, String patientLastName, String patientTcNo, Optional<Laborant> laborant) {
        Report report = new Report(diagnosisTitle, diagnosisDetails, LocalDateTime.now(), patientFirstName, patientLastName, patientTcNo, laborant);
        return reportRepository.save(report);

    }

    public Optional<Report> getById(long id) {
        return reportRepository.findById(id);
    }
    public List<Report> getByPatientFirstNameContaining(String firstName) { return reportRepository.findByPatientFirstNameContaining(firstName); };
    public List<Report> getByPatientLastNameContaining(String lastName) { return reportRepository.findByPatientLastNameContaining(lastName); };

    public Report getByPatientTcNo(String tcNo) { return reportRepository.findByPatientTcNo(tcNo); };

    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    public void deleteById(Long id) {
        reportRepository.deleteById(id);
    }
}
