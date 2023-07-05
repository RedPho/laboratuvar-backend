package com.emin.laboratuvar.services;

import com.emin.laboratuvar.models.Laborant;
import com.emin.laboratuvar.models.Report;
import com.emin.laboratuvar.repositories.LaborantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LaborantService {

    @Autowired
    private LaborantRepository laborantRepository;

    public Laborant store(String firstName, String lastName, String hospitalIdentityNo) {
        Laborant laborant = new Laborant(firstName, lastName, hospitalIdentityNo);
        return laborantRepository.save(laborant);

    }

    public Optional<Laborant> getById(long id) {
        return laborantRepository.findById(id);
    }

    public List<Laborant> getByFirstNameContaining(String firstName) { return laborantRepository.findByFirstNameContaining(firstName); };
    public List<Laborant> getByLastNameContaining(String lastName) { return laborantRepository.findByLastNameContaining(lastName); };

    public Laborant getByHospitalIdentityNo(String hospitalIdentityNo) { return laborantRepository.findByHospitalIdentityNo(hospitalIdentityNo); };

    public List<Laborant> findAll() {
        return laborantRepository.findAll();
    }


    public void deleteById(Long id) {
        laborantRepository.deleteById(id);
    }
}
