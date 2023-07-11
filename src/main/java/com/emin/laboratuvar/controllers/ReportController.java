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

@CrossOrigin
@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;
    @GetMapping("/reports")
    public ResponseEntity<List<Report>> getAllPatients(@RequestParam(required = false) String queryParameter) {
        System.out.println("PARAMETRE GELDI:" + queryParameter);
        try {
            List<Report> reports = new ArrayList<Report>();
            if (queryParameter == "" || queryParameter == null) {
                reports.addAll(reportService.findAll());
            }
            else {
                reports.addAll(reportService.getByPatientFirstNameContaining(queryParameter));
                reports.addAll(reportService.getByPatientLastNameContaining(queryParameter));
                reports.addAll(reportService.getByPatientTcNo(queryParameter));
            }
            if (reports.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity<Report> getPatientById(@PathVariable("id") long id) {
        Optional<Report> reportData = reportService.getById(id);
        if (reportData.isPresent()) {
            return new ResponseEntity<>(reportData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/reports")
    public ResponseEntity createPatient(@RequestBody Report report) {
        try {
            Report _report = reportService.store(report.getDiagnosisTitle(), report.getDiagnosisDetails(), report.getPatientFirstName(), report.getPatientLastName(), report.getPatientTcNo(), report.getLaborant(), report.getFileDB());
            return new ResponseEntity<>(_report, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/reports/{id}")
    public ResponseEntity<HttpStatus> deleteReport(@PathVariable("id") long id) {
        try {
            reportService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/reports/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable("id") long id, @RequestBody Report report) {
        Optional<Report> reportData = reportService.getById(id);

        if (reportData.isPresent()) {
            Report _report = reportService.update(id, report.getDiagnosisTitle(), report.getDiagnosisDetails(), report.getPatientFirstName(), report.getPatientLastName(), report.getPatientTcNo(), report.getLaborant());
            return new ResponseEntity<>(_report, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
