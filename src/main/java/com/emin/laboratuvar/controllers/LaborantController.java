package com.emin.laboratuvar.controllers;

import com.emin.laboratuvar.models.Laborant;
import com.emin.laboratuvar.models.Report;
import com.emin.laboratuvar.services.LaborantService;
import com.emin.laboratuvar.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
public class LaborantController {
    @Autowired
    private LaborantService laborantService;
    @GetMapping("/laborants")
    public ResponseEntity<List<Laborant>> getAllPatients(@RequestParam(required = false) String queryParameter) {
        try {
            List<Laborant> laborants = new ArrayList<Laborant>();

            if (queryParameter == null) {
                laborants.addAll(laborantService.findAll());
            }
            else {
                laborants.addAll(laborantService.getByFirstNameContaining(queryParameter));
                laborants.addAll(laborantService.getByLastNameContaining(queryParameter));
                laborants.add(laborantService.getByHospitalIdentityNo(queryParameter));
            }
            if (laborants.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(laborants, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/laborants/{id}")
    public ResponseEntity<Laborant> getLaborantById(@PathVariable("id") long id) {
        Optional<Laborant> laborantData = laborantService.getById(id);

        if (laborantData.isPresent()) {
            return new ResponseEntity<>(laborantData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/laborants")
    public ResponseEntity createLaborant(@RequestBody Laborant laborant) {
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            Laborant _laborant = laborantService.store(laborant.getFirstName(), laborant.getLastName(), laborant.getHospitalIdentityNo());
            return new ResponseEntity<>(_laborant, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/laborants/{id}")
    public ResponseEntity<HttpStatus> deleteLaborant(@PathVariable("id") long id) {
        try {
            laborantService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
