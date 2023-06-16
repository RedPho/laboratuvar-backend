package com.emin.laboratuvar.services;

import com.emin.laboratuvar.repositories.RaporRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaporService {

    @Autowired
    private RaporRepository raporRepository;
}
