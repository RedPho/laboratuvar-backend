package com.emin.laboratuvar.services;

import com.emin.laboratuvar.models.Patient;
import com.emin.laboratuvar.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient store(String firstName, String lastName, String tcNo) {
        Patient patient = new Patient(firstName, lastName, tcNo);
        return patientRepository.save(patient);
    }

    public Patient getById(Long id) {
        return patientRepository.findById(id).get();
    }

    public ArrayList<Patient> getByNameSurname(String name)
}
