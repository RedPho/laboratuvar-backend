package com.emin.laboratuvar.controllers;

import com.emin.laboratuvar.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HastaController {
    @Autowired
    private PatientService patientService;
}
