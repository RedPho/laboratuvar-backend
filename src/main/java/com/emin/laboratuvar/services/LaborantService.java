package com.emin.laboratuvar.services;

import com.emin.laboratuvar.models.Laborant;
import com.emin.laboratuvar.repositories.LaborantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaborantService {

    @Autowired
    private LaborantRepository laborantRepository;

    public Optional<Laborant> getById(long id) {
        return laborantRepository.findById(id);
    }
    public void deleteById(Long id) {
        laborantRepository.deleteById(id);
    }
}
