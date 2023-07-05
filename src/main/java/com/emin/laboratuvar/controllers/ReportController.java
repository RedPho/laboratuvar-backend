package com.emin.laboratuvar.controllers;

import com.emin.laboratuvar.models.Report;
import com.emin.laboratuvar.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;
    @GetMapping("/reports")
    public ResponseEntity<List<Report>> getAllPatients(@RequestParam(required = false) String queryParameter) {
        try {
            List<Report> reports = new ArrayList<Report>();

            if (queryParameter == null) {
                reports.addAll(reportService.findAll());
            }
            else {
                reports.addAll(reportService.getByPatientFirstNameContaining(queryParameter));
                reports.addAll(reportService.getByPatientLastNameContaining(queryParameter));
                reports.add(reportService.getByPatientTcNo(queryParameter));
            }
            if (reports.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity<Report> getPatientById(@PathVariable("id") long id) {
        Optional<Report> patientData = reportService.getById(id);

        if (patientData.isPresent()) {
            return new ResponseEntity<>(patientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/reports")
    public ResponseEntity createPatient(@RequestBody Report report) {
        try {
            Report _report = reportService.store(report.getDiagnosisTitle(), report.getDiagnosisDetails(), report.getPatientFirstName(), report.getPatientLastName(), report.getPatientTcNo(), report.getLaborant());
            return new ResponseEntity<>(_report, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/reports/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            reportService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
