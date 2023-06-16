package com.emin.laboratuvar.services;

import com.emin.laboratuvar.repositories.LaborantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaborantService {

    @Autowired
    private LaborantRepository laborantRepository;
}
